package sneha.zookeeper.demo.util;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public final class ClusterInfo {

  private static ClusterInfo clusterInfo = new ClusterInfo();

  public static ClusterInfo getClusterInfo() {
    return clusterInfo;
  }

  /*
  these will be ephemeral znodes
   */
  private List<String> liveNodes = new ArrayList<>();

  /*
  these will be persistent znodes
   */
  private List<String> allNodes = new ArrayList<>();

  private String master;
}
