package mongoAPI;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public interface Handler {

	public MongoCollection<Document> getAll(MongoDatabase db);

	public void addNew(MongoDatabase db, Scanner scanner);

	public void updateOne(MongoDatabase db, Scanner scanner);

	public void deleteOne(MongoDatabase db, Scanner scanner);
}
