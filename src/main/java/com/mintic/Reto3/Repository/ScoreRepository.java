package com.mintic.Reto3.Repository;

import com.mintic.Reto3.Model.Score;
import com.mintic.Reto3.Repository.Crud.ScoreCrudRepositoryInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ScoreRepository {
  
    @Autowired
    private ScoreCrudRepositoryInterfaz scoreCrudRepositoryInterfaz;
    
    
    public List  <Score> getScoreAll(){
        return (List<Score>) scoreCrudRepositoryInterfaz.findAll();
    }
    
    public Optional <Score> getScoreId(Integer id){
        return scoreCrudRepositoryInterfaz.findById(id);
    
    }
    
    public  Score saveScore(Score score){
        return scoreCrudRepositoryInterfaz.save(score);
    }
}
