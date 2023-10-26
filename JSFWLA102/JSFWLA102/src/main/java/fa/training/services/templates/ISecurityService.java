package fa.training.services.templates;

public interface ISecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
