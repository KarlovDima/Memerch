package dao.implementation;

import utils.DatabaseConnection;
import dao.GenericDAO;
import models.Clothes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClothesDAO implements GenericDAO<Clothes, Integer> {
    @Override
    public List<Clothes> getAll() {
        List<Clothes> clothesList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CLOTHES");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while ((resultSet.next())) {
                Clothes clothes = new Clothes();
                clothes.setId(resultSet.getInt(1));
                clothes.setName(resultSet.getString(2));
                clothes.setProducer(resultSet.getString(3));
                clothes.setPrice(resultSet.getFloat(4));
                clothes.setMem(resultSet.getString(5));
                clothes.setMaterial(resultSet.getString(6));
                clothes.setSize(resultSet.getString(7));
                clothesList.add(clothes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clothesList;
    }

    @Override
    public int update(Clothes entity) {
        int affectedRowsAmount = 0;
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CLOTHES " +
                     "SET NAME = ?, PRODUCER = ?, PRICE = ?, MEM = ?, MATERIAL = ?, SIZE = ? " +
                     "WHERE ID = ?")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getProducer());
            preparedStatement.setFloat(3, entity.getPrice());
            preparedStatement.setString(4, entity.getMem());
            preparedStatement.setString(5, entity.getMaterial());
            preparedStatement.setString(6, entity.getSize());
            preparedStatement.setInt(7, entity.getId());
            affectedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRowsAmount;
    }

    @Override
    public Clothes getEntityById(Integer id) {
        Clothes clothes = new Clothes();
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CLOTHES WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while ((resultSet.next())) {
                    clothes.setId(resultSet.getInt(1));
                    clothes.setName(resultSet.getString(2));
                    clothes.setProducer(resultSet.getString(3));
                    clothes.setPrice(resultSet.getFloat(4));
                    clothes.setMem(resultSet.getString(5));
                    clothes.setMaterial(resultSet.getString(6));
                    clothes.setSize(resultSet.getString(7));
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clothes;
    }

    @Override
    public int delete(Integer id) {
        int affectedRowsAmount = 0;
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CLOTHES WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            affectedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRowsAmount;
    }

    @Override
    public int create(Clothes entity) {
        int affectedRowsAmount = 0;
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CLOTHES " +
                     "(NAME, PRODUCER, PRICE, MEM, MATERIAL, SIZE) VALUES (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getProducer());
            preparedStatement.setFloat(3, entity.getPrice());
            preparedStatement.setString(4, entity.getMem());
            preparedStatement.setString(5, entity.getMaterial());
            preparedStatement.setString(6, entity.getSize());
            affectedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRowsAmount;
    }
}
