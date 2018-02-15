package dao.implementation;

import utils.DataSourceConnection;
import utils.DatabaseConnection;
import dao.GenericDAO;
import models.Cutlery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CutleryDAO implements GenericDAO<Cutlery, Integer> {
    @Override
    public List<Cutlery> getAll() {
        List<Cutlery> cutleryList = new ArrayList<>();
        try (Connection connection = DataSourceConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUTLERY");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while ((resultSet.next())) {
                Cutlery cutlery = new Cutlery();
                cutlery.setId(resultSet.getInt(1));
                cutlery.setName(resultSet.getString(2));
                cutlery.setProducer(resultSet.getString(3));
                cutlery.setPrice(resultSet.getFloat(4));
                cutlery.setMem(resultSet.getString(5));
                cutlery.setMaterial(resultSet.getString(6));
                cutlery.setVolume(resultSet.getString(7));
                cutleryList.add(cutlery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cutleryList;
    }

    @Override
    public int update(Cutlery entity) {
        int affectedRowsAmount = 0;
        try (Connection connection = DataSourceConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CUTLERY " +
                     "SET NAME = ?, PRODUCER = ?, PRICE = ?, MEM = ?, MATERIAL = ?, VOLUME = ? " +
                     "WHERE ID = ?")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getProducer());
            preparedStatement.setFloat(3, entity.getPrice());
            preparedStatement.setString(4, entity.getMem());
            preparedStatement.setString(5, entity.getMaterial());
            preparedStatement.setString(6, entity.getVolume());
            preparedStatement.setInt(7, entity.getId());
            affectedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRowsAmount;
    }

    @Override
    public Cutlery getEntityById(Integer id) {
        Cutlery cutlery = new Cutlery();
        try (Connection connection = DataSourceConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUTLERY WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while ((resultSet.next())) {
                    cutlery.setId(resultSet.getInt(1));
                    cutlery.setName(resultSet.getString(2));
                    cutlery.setProducer(resultSet.getString(3));
                    cutlery.setPrice(resultSet.getFloat(4));
                    cutlery.setMem(resultSet.getString(5));
                    cutlery.setMaterial(resultSet.getString(6));
                    cutlery.setVolume(resultSet.getString(7));
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cutlery;
    }

    @Override
    public int delete(Integer id) {
        int affectedRowsAmount = 0;
        try (Connection connection = DataSourceConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CUTLERY WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            affectedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRowsAmount;
    }

    @Override
    public int create(Cutlery entity) {
        int affectedRowsAmount = 0;
        try (Connection connection = DataSourceConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CUTLERY " +
                     "(NAME, PRODUCER, PRICE, MEM, MATERIAL, VOLUME) VALUES (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getProducer());
            preparedStatement.setFloat(3, entity.getPrice());
            preparedStatement.setString(4, entity.getMem());
            preparedStatement.setString(5, entity.getMaterial());
            preparedStatement.setString(6, entity.getVolume());
            affectedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRowsAmount;
    }
}
