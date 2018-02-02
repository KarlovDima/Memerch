package dao;

import dao.implementation.ClothesDAO;
import dao.implementation.CutleryDAO;
import dao.implementation.TrifleDAO;
import dao.implementation.UserDAO;

public class DAOFactory {
    private static ClothesDAO clothesDAO;
    private static CutleryDAO cutleryDAO;
    private static TrifleDAO trifleDAO;
    private static UserDAO userDAO;
    private static DAOFactory daoFactory;

    public static synchronized DAOFactory getInstance() {
        if (daoFactory == null)
            daoFactory = new DAOFactory();
        return daoFactory;
    }

    public ClothesDAO getClothesDAO() {
        if (clothesDAO == null) {
            clothesDAO = new ClothesDAO();
        }
        return clothesDAO;
    }

    public CutleryDAO getCutleryDAO() {
        if (cutleryDAO == null) {
            cutleryDAO = new CutleryDAO();
        }
        return cutleryDAO;
    }

    public TrifleDAO getTrifleDAO() {
        if (trifleDAO == null) {
            trifleDAO = new TrifleDAO();
        }
        return trifleDAO;
    }

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }
}
