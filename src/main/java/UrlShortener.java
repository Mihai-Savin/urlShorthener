public class UrlShortener {

    final String baseShortenedUrl = "http://short.com/";

    String urlShortener(String originalUrl, String seoKeyword) throws ValidationException {

        validateInput(originalUrl, seoKeyword);

        String result = baseShortenedUrl + seoKeyword;

        return result;
    }

    void validateInput(String originalUrl, String seoKeyword) throws ValidationException {
        boolean startsWithHttp = originalUrl.toUpperCase().startsWith("HTTP");

        if (!startsWithHttp || seoKeyword.length() > 20) {
            throw new ValidationException();
        }

    }

    class ValidationException extends Exception {

    }

}
