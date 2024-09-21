package run;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class RunJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);
    private final ObjectMapper objectMapper;
    private final JdbcRunRepository runRepository;

    public RunJsonDataLoader(JdbcRunRepository runRepository, ObjectMapper objectMapper) {
    	this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(runRepository.count() == 0) {	//jer se pravi nova DB i namo da je 0
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {    //gde je fajl?
                RunsListForJson allRunsFromJson = objectMapper.readValue(inputStream, RunsListForJson.class);
                log.info("Reading {} runs from JSON data and saving to in-memory collection.", allRunsFromJson.runs().size());
                runRepository.saveAll(allRunsFromJson.runs());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading Runs from JSON data because the collection contains data.");
        }
    }

}
