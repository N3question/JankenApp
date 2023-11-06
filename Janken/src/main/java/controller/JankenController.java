package controller;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JankenController
 */
@WebServlet("/janken")
public class JankenController extends HttpServlet {
//	private static final long serialVersionUID = 1L; いらない
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public JankenController() { 19-22行いらない
//        super();
        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath()); いらない
		
		// doGetを使用してwebブラウザで開く
		String view = "/WEB-INF/views/execution.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response); いらない
		
		// 1. フォームから送信されたデータを取得
		String myHand = request.getParameter("selection");
		
		// 2. 取得したデータをリクエスト属性として設定
			// request.setAttribute => サーブレットやJSPなどのサーバーサイドコードでデータを保持 + クライアントの要求に応じて表示または処理
			// 第一引数には属性の名前（キー）、第二引数には属性の値（オブジェクト）を指定
		request.setAttribute("selection", myHand);
		
		// 3. PCサイド配列を定義
		String[] strPcOption = {"Rock", "Paper", "Scissors"};
       
		// 4. checkboxから対戦人数を取得
//		String checkboxSelection = request.getParameter("multiPlayCheckbox");
//        if (checkboxSelection != null) { // チェックボックスが選択されている場合の処理
//        	System.out.println("チェックボックスが選択されました。");
//        } else { // チェックボックスが選択解除されている場合の処理
//            System.out.println("チェックボックスが選択解除されました。");
//        }
        
        // 4'. プルダウンから対戦人数を取得
        String playerCount = request.getParameter("playerCount");
        if (playerCount != null) {
            // 5'. 対戦人数に応じて条件分岐
            if (playerCount.equals("2")) {
            	// 6'. ランダムにジャンケンの手を選択
                Random random = new Random(); // インスタンス化
    	 		int randomNum = random.nextInt(strPcOption.length); // 0から2までのランダムな整数を生成
    	 		
    	 		// 7'. ランダムな乱数に対応する要素を取得
    	 		String computer1Hand = strPcOption[randomNum];
    	        request.setAttribute("pc1Selection", computer1Hand);
    	        
    		    // 8'. if文を使ってじゃんけん結果を判定
    	        	// 文字列の比較 => equalsメソッドを使用する必要
    	        if (myHand.equals(computer1Hand)) { //要確認
    	        	request.setAttribute("result", "Draw."); // 引き分け
    	        } else if ((myHand.equals("Rock") && computer1Hand.equals("Scissors")) || 
    	                   (myHand.equals("Paper") && computer1Hand.equals("Rock")) ||
    	                   (myHand.equals("Scissors") && computer1Hand.equals("Paper"))) {
    	        	request.setAttribute("result", "You win!"); // プレイヤーの勝ち
    	        } else {
    	        	request.setAttribute("result", "You lose..."); // コンピュータの勝ち
    	        }

    	        // 結果
    	        System.out.println("Player人数が2人の状態です");
    	        System.out.println("Userの手: " + myHand);
                System.out.println("Computer1の手: " + computer1Hand);
            } else if (playerCount.equals("3")) {
                String computer1Hand = getRandomHand(strPcOption); // コンピュータ1の手をランダムに選択
                String computer2Hand = getRandomHand(strPcOption); // コンピュータ2の手をランダムに選択
                request.setAttribute("pc1Selection", computer1Hand);
                request.setAttribute("pc2Selection", computer2Hand);
                
                if (myHand.equals(computer1Hand) && myHand.equals(computer2Hand)) { 
    	        	request.setAttribute("result", "Draw.");
    	        } else if ((myHand.equals("Rock") && computer1Hand.equals("Scissors")) ||
    	                (myHand.equals("Paper") && computer1Hand.equals("Rock")) ||
    	                (myHand.equals("Scissors") && computer1Hand.equals("Paper"))) {
    	        	request.setAttribute("result", "You win!");
    	        } else {
    	        	request.setAttribute("result", "You lose...");
    	        }
                String result = "";

                if (myHand.equals(computer1Hand) && myHand.equals(computer2Hand)) {
                    result = "Draw.";
                } else if ((myHand.equals("Rock") && computer1Hand.equals("Paper") && computer2Hand.equals("Scissors")) ||
                		   (myHand.equals("Rock") && computer1Hand.equals("Scissors") && computer2Hand.equals("Paper")) ||
                           (myHand.equals("Paper") && computer1Hand.equals("Scissors") && computer2Hand.equals("Rock")) ||
                           (myHand.equals("Paper") && computer1Hand.equals("Rock") && computer2Hand.equals("Scissors")) ||
                           (myHand.equals("Scissors") && computer1Hand.equals("Rock") && computer2Hand.equals("Paper")) || 
                           (myHand.equals("Scissors") && computer1Hand.equals("Paper") && computer2Hand.equals("Rock"))
                		) {
                    result = "Draw.";
                } else if ((myHand.equals("Rock") && computer1Hand.equals("Scissors") && computer2Hand.equals("Scissors")) ||
                           (myHand.equals("Paper") && computer1Hand.equals("Rock") && computer2Hand.equals("Rock")) ||
                           (myHand.equals("Scissors") && computer1Hand.equals("Paper") && computer2Hand.equals("Paper")) ||
                           (myHand.equals("Rock") && computer1Hand.equals("Rock") && computer2Hand.equals("Scissors")) ||
                           (myHand.equals("Rock") && computer1Hand.equals("Scissors") && computer2Hand.equals("Rock")) ||
                           (myHand.equals("Paper") && computer1Hand.equals("Paper") && computer2Hand.equals("Rock")) ||
                           (myHand.equals("Paper") && computer1Hand.equals("Rock") && computer2Hand.equals("Paper")) ||
                           (myHand.equals("Scissors") && computer1Hand.equals("Scissors") && computer2Hand.equals("Paper")) ||
                           (myHand.equals("Scissors") && computer1Hand.equals("Paper") && computer2Hand.equals("Scissors"))
                		) {
                    result = "You win!";
                } else {
                    result = "You lose...";
                }
                request.setAttribute("result", result);
                
                // 結果
                System.out.println("Player人数が3人の状態です");
                System.out.println("Userの手: " + myHand);
                System.out.println("Computer1の手: " + computer1Hand);
                System.out.println("Computer2の手: " + computer2Hand);
            } 
        }
        
        // 9. executionResult.jsp にリダイレクト
        	// リダイレクト先を変数に格納し可読性をあげる
        String view = "/WEB-INF/views/executionResult.jsp";
        	// getRequestDispatcher => サーブレット内でリクエストの処理を転送（フォワード）するためのオブジェクトを取得するために使用
        request.getRequestDispatcher(view).forward(request, response);
        
        String fontFamily = "'Rajdhani', sans-serif"; // ここに新しいフォントを設定
        request.getSession().setAttribute("selection", fontFamily);
        
	}
	
	// ランダムにジャンケンの手を選択
    public static String getRandomHand(String[] hands) {
        Random random = new Random();
        int randomIndex = random.nextInt(hands.length);
        return hands[randomIndex];
    }

}
