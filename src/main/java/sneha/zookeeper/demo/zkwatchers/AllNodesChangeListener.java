package sneha.zookeeper.demo.zkwatchers;

import sneha.zookeeper.demo.util.ClusterInfo;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkChildListener;

import java.util.List;

@Slf4j
public class AllNodesChangeListener implements IZkChildListener {


  @Override
  public void handleChildChange(String parentPath, List<String> currentChildren) {
    log.info("current all node size: {}", currentChildren.size());
    ClusterInfo.getClusterInfo().getAllNodes().clear();
    ClusterInfo.getClusterInfo().getAllNodes().addAll(currentChildren);
  }
}
