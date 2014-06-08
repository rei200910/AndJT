package myblog;


import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;






/**
  * 操作 Blog 的業務邏輯
 */
public class BlogController {
	
	/**     
	 *  Singleton 的實例
     */
    private static BlogController controller = new BlogController();

  
    /**
     * 取得此類別的實例 (instance)
     * 
     * @return BlogController的實例 (instance)
     */
    public static BlogController getInstance() {
        return controller;
    }

    private BlogController() {
    }

    /**
     * 登入 (post)topic 文章
     * @param topic 文章
     */
    public void postTopic(Topic topic) {
         String sql = "INSERT INTO topic(title,content)"
        		 + "VALUES("+"'"+topic.getTitle()+"'"
        		 +",'"+topic.getContent()+"'"+")";
    	
    	
            Connection con = null;
            Statement smt = null;
            
            try {
				con = ConnectionManager.getConnection();
				smt = con.createStatement();
	            smt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if (smt != null){
					try {
						smt.close();
					} catch (SQLException ignore) {
						
					}
				}
				if (con != null){
					try {
						con.close();
					} catch (SQLException ignore) {
						
					}
				}
			}
            
            
       
    }

    /**
     * 取得最近(即全部)的文章
     * 
     * @return 文章清單
     */
    public List<Topic> getTopics() {
    	String sql = "SELECT * FROM TOPIC";
    	List<Topic> topics = new ArrayList<Topic>();
    	
    	
    	
    	 Connection con = null;
         Statement smt = null;
         ResultSet rs = null;
         
         try {
				con = ConnectionManager.getConnection();
				smt = con.createStatement();
	            rs = smt.executeQuery(sql);
	            while (rs.next()) {
	            	Topic topic = new Topic();
	            	topic.setId(rs.getInt("topicid"));
	            	topic.setPostDate(rs.getTimestamp("post_date"));
	            	topic.setTitle(rs.getString("title"));
	            	topic.setContent(rs.getString("content"));
	            	
	            	topics.add(topic);	            	
	            }
	            
			} catch (SQLException e) {
				 e.printStackTrace();
			} finally {
				if (rs != null){
					try {
						rs.close();
					} catch (SQLException ignore) {
						
					}
				}
				
				if (smt != null){
					try {
						smt.close();
					} catch (SQLException ignore) {
						
					}
				}
				
				if (con != null){
					try {
						con.close();
					} catch (SQLException ignore) {
						
					}
				}
				
			}
    	
    	
    	
        return topics;
    	
    }
	
    
    public static void main(String[] args) {
    	BlogController ctrl = BlogController.getInstance();
    	List<Topic> topics = ctrl.getTopics();
    	for (int i = 0; i < topics.size(); i++) {
    		System.out.println(topics.get(i));
    		
    	}
		
    	System.out.println("END");
	}
    
    
	
}
