package ps.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import ps.model.Jugador;

@EnableMongoRepositories
public interface JugadorRepository extends MongoRepository<Jugador, ObjectId> {


}
