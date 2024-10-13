package fullstack_moviesAPI.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	public Review createReviews(String reviewBody , String imdbId )
	{
		Review review = reviewRepository.insert(new Review(reviewBody));
		
		//ObjectId reviewId = new ObjectId();
		
		UpdateResult result =mongoTemplate.update(Movie.class)
			    .matching(Criteria.where("imdbId").is(imdbId))
			    .apply(new Update().push("reviews", review))
			    .first();

		
		System.out.println("Matched Count: " + result.getMatchedCount());
		System.out.println("Modified Count: " + result.getModifiedCount());
		
		return review;
		
		
	}
}
