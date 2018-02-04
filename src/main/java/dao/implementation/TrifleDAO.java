package dao.implementation;

import utils.DatabaseConnection;
import dao.GenericDAO;
import models.Trifle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrifleDAO implements GenericDAO<Trifle, Integer> {
    @Override
    public List<Trifle> getAll() {
        List<Trifle> trifleList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TRIFLE");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while ((resultSet.next())) {
                Trifle trifle = new Trifle();
                trifle.setId(resultSet.getInt(1));
                trifle.setName(resultSet.getString(2));
                trifle.setProducer(resultSet.getString(3));
                trifle.setPrice(resultSet.getFloat(4));
                trifle.setMem(resultSet.getString(5));
                trifle.setMaterial(resultSet.getString(6));
                trifle.setAmount(resultSet.getInt(7));
                trifleList.add(trifle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trifleList;
    }

    @Override
    public int update(Trifle entity) {
        int affectedRowsAmount = 0;
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE TRIFLE " +
                     "SET NAME = ?, PRODUCER = ?, PRICE = ?, MEM = ?, MATERIAL = ?, AMOUNT = ? " +
                     "WHERE ID = ?")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getProducer());
            preparedStatement.setFloat(3, entity.getPrice());
            preparedStatement.setString(4, entity.getMem());
            preparedStatement.setString(5, entity.getMaterial());
            preparedStatement.setInt(6, entity.getAmount());
            preparedStatement.setInt(7, entity.getId());
            affectedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRowsAmount;
    }

    @Override
    public Trifle getEntityById(Integer id) {
        Trifle trifle = new Trifle();
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TRIFLE WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while ((resultSet.next())) {
                    trifle.setId(resultSet.getInt(1));
                    trifle.setName(resultSet.getString(2));
                    trifle.setProducer(resultSet.getString(3));
                    trifle.setPrice(resultSet.getFloat(4));
                    trifle.setMem(resultSet.getString(5));
                    trifle.setMaterial(resultSet.getString(6));
                    trifle.setAmount(resultSet.getInt(7));
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trifle;
    }

    @Override
    public int delete(Integer id) {
        int affectedRowsAmount = 0;
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM TRIFLE WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            affectedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRowsAmount;
    }

    @Override
    public int create(Trifle entity) {
        int affectedRowsAmount = 0;
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TRIFLE " +
                     "(NAME, PRODUCER, PRICE, MEM, MATERIAL, AMOUNT) VALUES (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getProducer());
            preparedStatement.setFloat(3, entity.getPrice());
            preparedStatement.setString(4, entity.getMem());
            preparedStatement.setString(5, entity.getMaterial());
            preparedStatement.setInt(6, entity.getAmount());
            affectedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRowsAmount;
    }
}
