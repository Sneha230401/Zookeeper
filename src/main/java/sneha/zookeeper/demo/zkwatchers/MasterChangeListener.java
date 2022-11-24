package sneha.zookeeper.demo.zkwatchers;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import sneha.zookeeper.demo.api.ZkService;
import sneha.zookeeper.demo.util.ClusterInfo;

import java.util.List;

@Setter
@Slf4j
public class MasterChangeListener implements IZkChildListener {

  private ZkService zkService;

  @Override
  public void handleChildChange(String parentPath, List<String> currentChildren) {
    if (currentChildren.isEmpty()) {
      log.info("master deleted, recreating master!");
      ClusterInfo.getClusterInfo().setMaster(null);
      try {

        zkService.electForMaster();
      } catch (ZkNodeExistsException e) {
        log.info("master already created");
      }
    } else {
      String leaderNode = zkService.getLeaderNodeData();
      log.info("updating new master: {}", leaderNode);
      ClusterInfo.getClusterInfo().setMaster(leaderNode);
    }
  }
}
