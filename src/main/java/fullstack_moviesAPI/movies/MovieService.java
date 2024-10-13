package fullstack_moviesAPI.movies;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired  
	private MovieRepository movieRepository;
	public List<Movie> allMovies()
	{ 
		
		    try {
		    	System.out.println("HIIIIIIIIIIIIIIIIIII");
		    	System.out.println();
		        return movieRepository.findAll();
		    } catch (Exception e) {
		        System.err.println("Error fetching movies: " + e.getMessage());
		        e.printStackTrace();
		        return Collections.emptyList();
		    }
		}

	public Optional<Movie> singleMovie(String imdbId)
	{
		return movieRepository.findMovieByImdbId(imdbId);
	}
		
	}



	
