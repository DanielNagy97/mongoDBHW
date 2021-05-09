package mongoAPI;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Methods {

	public void deleteById(MongoDatabase db, String collectionName, Float id) {
		try {
			MongoCollection<Document> collection = db.getCollection(collectionName);

			collection.deleteOne(eq("_id", id));
			System.out.println("OK");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(MongoDatabase db, String collectionName, Float id, String field, String newVal) {
		try {
			MongoCollection<Document> collection = db.getCollection(collectionName);

			collection.updateOne(eq("_id", id), new Document("$set", new Document(field, newVal)));
			System.out.println("OK");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(MongoDatabase db, String collectionName, Float id, String field, Float newVal) {
		try {
			MongoCollection<Document> collection = db.getCollection(collectionName);

			collection.updateOne(eq("_id", id), new Document("$set", new Document(field, newVal)));
			System.out.println("OK");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MongoCollection<Document> query(MongoDatabase db, String collectionName) {
		try {
			MongoCollection<Document> collection = db.getCollection(collectionName);

			return collection;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insert(MongoDatabase db, String collectionName, Document newDocument) {
		try {
			MongoCollection<Document> collection = db.getCollection(collectionName);

			collection.insertOne(newDocument);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
