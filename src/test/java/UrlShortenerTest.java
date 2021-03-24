import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlShortenerTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void checkAppender() throws UrlShortener.ValidationException {
        // arrange
        String expected = "http://short.com/MY-NEW-WS";

        // act
        UrlShortener urlShortener = new UrlShortener();
        String result = urlShortener.urlShortener("http://whatever", "MY-NEW-WS");

        // assert
        assertEquals(expected, result, "Something went wrong.");

    }

    @Test
    void checkValidator() {
        UrlShortener urlShortener = new UrlShortener();

        assertThrows(UrlShortener.ValidationException.class, () -> {
            urlShortener.validateInput("doesNotStartWithHttp", "keyword");

        });

        assertThrows(UrlShortener.ValidationException.class, () -> {
            urlShortener.validateInput("http...", "keywordmorethan20characterslooooong");
        });

    }

}
