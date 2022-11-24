package sneha.zookeeper.demo.zkwatchers;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkChildListener;
import sneha.zookeeper.demo.api.ZkService;
import sneha.zookeeper.demo.util.ClusterInfo;

import java.util.Collections;
import java.util.List;

import static sneha.zookeeper.demo.util.ZkDemoUtil.ELECTION_NODE_2;

@Slf4j
@Setter
public class MasterChangeListenerApproach2 implements IZkChildListener {

  private ZkService zkService;

  @Override
  public void handleChildChange(String parentPath, List<String> currentChildren) {
    if (currentChildren.isEmpty()) {
      throw new RuntimeException("No node exists to select master!!");
    } else {
      //get least sequenced znode
      Collections.sort(currentChildren);
      String masterZNode = currentChildren.get(0);

      // once znode is fetched, fetch the znode data to get the hostname of new leader
      String masterNode = zkService.getZNodeData(ELECTION_NODE_2.concat("/").concat(masterZNode));
      log.info("new master is: {}", masterNode);

      //update the cluster info with new leader
      ClusterInfo.getClusterInfo().setMaster(masterNode);
    }
  }
}
