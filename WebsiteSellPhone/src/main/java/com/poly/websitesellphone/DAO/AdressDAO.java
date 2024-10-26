package com.poly.websitesellphone.DAO;


import com.poly.websitesellphone.Service.AdressInterface;
import com.poly.websitesellphone.model.AdressModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdressDAO extends DataDAO implements AdressInterface {
    @Override
    public List<AdressModel> selectAll() {
        List<AdressModel> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            ResultSet rs = query(ADRESS_SELECT_ALL);
            while (rs.next()) {
                int idAddress = rs.getInt("id_address");
                int idUser = rs.getInt("id_user");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String fullName = rs.getString("full_name");
                list.add(new AdressModel(idAddress, idUser, phone, address, fullName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public AdressModel selectById(int id) {
        AdressModel adressModel = null;
        try {
            Connection con = getConnection();
            ResultSet rs = query(ADRESS_SELECT_BY_ID, id);
            while (rs.next()) {
                int idAddress = rs.getInt(COLUMN_ID_ADRESS);
                int idUser = rs.getInt(COLUMN_ID_USER);
                String phone = rs.getString(COLUMN_PHONE);
                String address = rs.getString(COLUMN_ADDRESS);
                String fullName = rs.getString(COLUMN_FULL_NAME);
                adressModel = new AdressModel(idAddress, idUser, phone, address, fullName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adressModel;
    }

    @Override
    public List<AdressModel> selectByIdUser(int idUser) {
        List<AdressModel> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            ResultSet rs = query(ADRESS_SELECT_BY_ID_USER, idUser);
            while (rs.next()) {
                int idAddress = rs.getInt(COLUMN_ID_ADRESS);
                String phone = rs.getString(COLUMN_PHONE);
                String address = rs.getString(COLUMN_ADDRESS);
                String fullName = rs.getString(COLUMN_FULL_NAME);
                list.add(new AdressModel(idAddress, idUser, phone, address, fullName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean insert(AdressModel adressModel) {
        boolean rs = false;
        try {
            Connection con = getConnection();
            update(ADRESS_INSERT,
                    adressModel.getIdUser(),
                    adressModel.getPhone(),
                    adressModel.getAdress(),
                    adressModel.getFullName()
            );
            rs = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public boolean update(AdressModel adressModel) {
        boolean rs = false;
        try {
            Connection con = getConnection();
            update(ADRESS_UPDATE,
                    adressModel.getPhone(),
                    adressModel.getAdress(),
                    adressModel.getFullName(),
                    adressModel.getIdAddress()
            );
            rs = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public boolean delete(int idAddress) {
        boolean rs = false;
        try {
            Connection con = getConnection();
            update(ADRESS_DELETE,
                    idAddress
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
