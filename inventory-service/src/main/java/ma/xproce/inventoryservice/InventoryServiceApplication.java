package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.entities.Creator;
import ma.xproce.inventoryservice.entities.Video;
import ma.xproce.inventoryservice.repositories.CreatorRepository;
import ma.xproce.inventoryservice.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            List<Creator> creators = List.of(Creator.builder().name("ai")
                    .email("ai@gmail.com").build(), Creator.builder().name("to")
                    .email("to@gmail.com").build(), Creator.builder().name("ryt")
                    .email("ryt@gmail.com").build());
            for (Creator creator : creators) {
                creatorRepository.save(creator);
            }

            List<Video> videos = List.of(Video.builder().name("football")
                    .url("football.com").datePublication(new Date())
                    .description(" video").creator(creators.get(1))
                    .build(), Video.builder().name("music").url("music.com")
                    .datePublication(new Date()).description(" video 2")
                    .creator(creators.get(0)).build(), Video.builder().name("fashion")
                    .url("fashion.com").datePublication(new Date())
                    .description("video 3")
                    .creator(creators.get(2)).build());
            for (Video video : videos) {
                videoRepository.save(video);
            }
        };
    }
}
