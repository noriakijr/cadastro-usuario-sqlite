package com.noriaki.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noriaki.odan on 28/01/2015.
 */
public class UsuarioDao {
    private SQLiteDatabase db;

    public UsuarioDao(Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
    }

    public void inserir(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("login", usuario.getLogin());
        values.put("senha", usuario.getSenha());

        db.insert("usuario", null, values);
    }

    public void atualizar(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("login", usuario.getLogin());
        values.put("senha", usuario.getSenha());

        db.update("usuario", values, "_id = ?", new String[]{usuario.getId().toString()});
    }

    public void deletar(Usuario usuario) {
        db.delete("usuario", "_id = " + usuario.getId(), null);
    }

    public List<Usuario> buscar() {
        List<Usuario> usuarios = new ArrayList<>();
        String[] colunas = new String[]{"_id", "nome", "login", "senha"};

        Cursor cursor = db.query("usuario", colunas, null, null, null, null, "nome ASC");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                Usuario usuario = new Usuario();
                usuario.setId(cursor.getLong(0));
                usuario.setNome(cursor.getString(1));
                usuario.setLogin(cursor.getString(2));
                usuario.setSenha(cursor.getString(3));

                usuarios.add(usuario);

            } while (cursor.moveToNext());
        }

        return usuarios;
    }

}
