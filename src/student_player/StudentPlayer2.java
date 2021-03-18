//package student_player;
//
//import boardgame.Board;
//import boardgame.Move;
//import pentago_twist.PentagoPlayer;
//import pentago_twist.PentagoBoardState;
//
///** A player file submitted by a student. */
//public class StudentPlayer2 extends PentagoPlayer {
//
//	/**
//	 * You must modify this constructor to return your student number. This is
//	 * important, because this is what the code that runs the competition uses to
//	 * associate you with your agent. The constructor should do nothing else.
//	 */
//	public StudentPlayer2() {
//		super("RASTA");
//	}
//
//	/**
//	 * This is the primary method that you need to implement. The ``boardState``
//	 * object contains the current state of the game, which your agent must use to
//	 * make decisions.
//	 */
//	public Move chooseMove(PentagoBoardState boardState) {
//		long endTime = System.currentTimeMillis() + 2000;
//		
//		Node rootNode = null;
//		
//		if (MyTools.root != null) {		
//
//			for (Node node : MyTools.root.getChildArray()) {
//				if (MyTools.AreBoardsEqual(boardState.getBoard(), node.state.getBoard(), PentagoBoardState.BOARD_SIZE)) {
//					rootNode = node;
//					rootNode.parent = null;
//					break;
//				}
//			}
//		}
//		if (rootNode == null) {
//			rootNode =  new Node(boardState);
//		}
//		
//
//		while (System.currentTimeMillis() < endTime) {
//			Node bestNode = rootNode.getBestChildToExpand();
//			bestNode.expand();
//			Node nodeToExplore = bestNode.getRandomChild();
//
//			int playerNum = boardState.getTurnPlayer();
//			int simResult = nodeToExplore.simRandomGame(playerNum);
//
//			boolean didWin = simResult == playerNum;
//
//			nodeToExplore.backPropogation(didWin);
//		}
//
//		Node winnerNode = rootNode.getBestChildToPlay();
//		return winnerNode.getMove();
//	}
//}