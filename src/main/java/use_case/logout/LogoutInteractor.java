package use_case.logout;

import entity.User;
import use_case.change_password.ChangePasswordOutputData;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {

        String currentUsername = userDataAccessObject.getCurrentUsername();
        userDataAccessObject.setCurrentUsername(null);

        LogoutOutputData logoutOutputData = new LogoutOutputData(currentUsername);

        logoutPresenter.prepareSuccessView(logoutOutputData);

    }
}

