package sneha.zookeeper.demo.api;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZkService {

  String getLeaderNodeData();

  void electForMaster();

  boolean masterExists();

  void addToLiveNodes(String nodeName, String data);

  List<String> getLiveNodes();

  void addToAllNodes(String nodeName, String data);

  List<String> getAllNodes();

  void deleteNodeFromCluster(String node);

  void createAllParentNodes();

  String getLeaderNodeData2();

  String getZNodeData(String path);

  void createNodeInElectionZnode(String data);

  void registerChildrenChangeWatcher(String path, IZkChildListener iZkChildListener);

  void registerZkSessionStateListener(IZkStateListener iZkStateListener);
}
