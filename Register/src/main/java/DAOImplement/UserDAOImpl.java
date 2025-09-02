package DAOImplement;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import DAO.UserDAO;
import DBConnection.DBConnection;
import Model.User;

public class UserDAOImpl implements UserDAO {
    private MongoDatabase db;
    private MongoCollection<Document> users;

    public UserDAOImpl() {
        this.db = DBConnection.getConnection();
        this.users = db.getCollection("users");
    }

    @Override
    public User get(String username) {
        Document doc = users.find(Filters.eq("username", username)).first();
        if (doc != null) {
            User user = new User(
                doc.getInteger("id"),
                doc.getString("email"),
                doc.getString("username"),
                doc.getString("fullname"),
                doc.getString("password"),
                doc.getString("avatar"),
                doc.getInteger("roleid"),
                doc.getString("phone"),
                doc.getDate("createdDate")
            );
            return user;
        }
        return null;
    }

    @Override
    public void insert(User user) {
        Document doc = new Document("id", user.getId())
                .append("email", user.getEmail())
                .append("username", user.getUserName())
                .append("fullname", user.getFullName())
                .append("password", user.getPassWord())
                .append("avatar", user.getAvatar())
                .append("roleid", user.getRoleid())
                .append("phone", user.getPhone())
                .append("createdDate", user.getCreatedDate());
        users.insertOne(doc);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return users.find(Filters.eq("email", email)).first() != null;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return users.find(Filters.eq("username", username)).first() != null;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return users.find(Filters.eq("phone", phone)).first() != null;
    }
}
