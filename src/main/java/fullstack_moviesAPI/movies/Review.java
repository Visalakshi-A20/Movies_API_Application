package fullstack_moviesAPI.movies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	
	
	private ObjectId id;
	private String body;
	
	
	 public Review(String body)
	 {
		 this.body=body;
	 }


	public ObjectId getId() {
		return id;
	}
	
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", body=" + body + "]";
	}
	
	
	

	
}
