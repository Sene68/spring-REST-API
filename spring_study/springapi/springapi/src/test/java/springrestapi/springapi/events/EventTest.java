package springrestapi.springapi.events;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
                .name("Spring REST API")
                .description("REST API development").build();

        Assertions.assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        //Given
        String name = "Event";
        String description = "Spring REST API";

        //When
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        //Then
        Assertions.assertThat(event.getName()).isEqualTo(name);

    }

}