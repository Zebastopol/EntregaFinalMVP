package com.example.entregafinalmvp.view.actividades;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.entregafinalmvp.R;
import com.example.entregafinalmvp.interactor.usocamara.Permisos;
import com.example.entregafinalmvp.view.fragmentos.FragEliminarRegistro;
import com.example.entregafinalmvp.view.fragmentos.FragMostrarEquipos;
import com.example.entregafinalmvp.view.fragmentos.FragRegistrarEquipos;
import com.google.android.material.navigation.NavigationView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class otraActividad extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_PERMISSION_CAMERA = 100; //detectar la respuesta del usuario si es OK
    private static final int TAKE_PICTURE = 101; //detecta si se tomo la foto con la camara del celular
    private static final int REQUEST_PERMISSION_WRITE_STORAGE = 200; //detectar la respuesta del usuario si es ok

    DrawerLayout myDrawerLayout;
    NavigationView myNavigationView;
    Toolbar myToolbar;
    ActionBarDrawerToggle toogle; //para implementar el icono de hamburguesa
    //ImageView para mostrar la foto sacada en el fragmento
    ImageView imActual;
    //variable para nombrar fotos
    String codfoto = "";
    Bitmap bitmap;
    List<Bitmap> listaFotos = new ArrayList<>();
    String nombre = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra_actividad);

        //vistas para implementar drawer
        myDrawerLayout = findViewById(R.id.myDrawerLayout);
        myNavigationView = findViewById(R.id.myNavigationView);
        myToolbar = findViewById(R.id.myToolbar);
        /**variable que viene de actividad anterior EN FragRegistrarEquipos.java*/
        nombre = getIntent().getStringExtra("x");
        /**variable que viene de actividad anterior*/
        //mostrar actionbar
        setSupportActionBar(myToolbar);
        //eventos click en items de navigationDrawer
        myNavigationView.setNavigationItemSelectedListener(this);

        //para iniciar fragmento
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.FrameLayout, new FragRegistrarEquipos())
                .commit();
        setTitle("Registrar equipo - " + nombre);

        //para activar icono hamburguesa
        //toogle = new ActionBarDrawerToggle(this, myDrawer, myToolbar, R.string.drawer_open, R.string.drawer_close);
        toogle = setDrawerToogle();
        myDrawerLayout.addDrawerListener(toogle); //para oir al icono de hamburguesa

    }

    /*
     * implementacion de Camara permisos permisosCamara1() y permisoCamaraGeneral()
     */
    public void permisosCamara1(ImageView ima){
        this.imActual = ima;
        permisoCamaraGeneral();
    }

    public void permisosCamara2(ImageView ima){
        this.imActual = ima;
        permisoCamaraGeneral();
    }

    public void permisoCamaraGeneral(){
        /*
            Permisos p = new Permisos(this, this);
            int x = p.permisoGeneral();
            if(x == 1) tomarFoto();
        */

        if(new Permisos(this, this).permisoGeneral() == 1) tomarFoto();

    }
    /*
     * implementacion de Camara permisos permisosCamara1() y permisoCamaraGeneral()
     */

    /*
     * tomar foto (abre intent implicito camara)
     */

    /*
     * tomar foto (abre intent implicito camara)
     */

    /*
     * implementacion de respuestas al sacar la foto
     */

    public void tomarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, TAKE_PICTURE);
        }
    }
    /*
     * tomar foto (abre intent implicito camara)
     */

    /*
     * implementacion de respuestas al sacar la foto
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == TAKE_PICTURE){
            if (resultCode == Activity.RESULT_OK && data != null){
                listaFotos.add((Bitmap) data.getExtras().get("data"));
                bitmap = (Bitmap) data.getExtras().get("data");
                //invocamos al fragmento para mostrar imagen en su respectivo ImageView
                FragRegistrarEquipos.mostrarImagen(this.imActual, bitmap);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    /*
     * implementacion de respuestas al sacar la foto
     */


    /*
     * implementacion permisos de almacenamiento y guardado de fotos permisosAlmacenamiento1()
     */
    public void permisosAlmacenamiento(String codigo){
        codfoto = codigo;
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P){ //Apis mas antiguas < 28
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    guardarFoto1();
                    guardarFoto2();
                }
                else{
                    //api < 28 (Q)
                    ActivityCompat.requestPermissions(
                            this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            REQUEST_PERMISSION_WRITE_STORAGE
                    );
                }
            }
            else{
                guardarFoto1();
                guardarFoto2();
            }
        }
        else{
            guardarFoto1();
            guardarFoto2();
        }
    }


    /**
     * M??todo para almacenar foto fisicamente
     */
    public void guardarFoto1(){ //Android Q y posteriores
        OutputStream outputStream = null;
        File file = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){ //versiones recientes
            ContentResolver resolver = getContentResolver(); //para manejar los values
            ContentValues values = new ContentValues(); //metadatos de imagenes tipo, render, etc

            SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
            String tiempo = formatter.format(new Date());

            //agrego el due??o de la foto
            String filename = codfoto + "@foto1" + "@" + tiempo;

            values.put(MediaStore.Images.Media.DISPLAY_NAME, filename);
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/MyApp");
            values.put(MediaStore.Images.Media.IS_PENDING, 1); //1 la imagen se esta procesando

            Uri collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY); //construir una ruta en android
            Uri imageUri = resolver.insert(collection, values); //insertando en memoria la ruta anterior


            try {
                outputStream = resolver.openOutputStream(imageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            values.clear();
            values.put(MediaStore.Images.Media.IS_PENDING, 0);
            resolver.update(imageUri, values, null, null);
        }
        else{ //Apis mas antiguas < 28
            String imageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();

            SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
            String tiempo = formatter.format(new Date());

            //agrego el due??o de la foto
            String filename = codfoto + "@foto1" + "@" + tiempo + ".jpg"; //nombre del archivo

            file = new File(imageDir, filename);

            try {
                outputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        boolean saved = listaFotos.get(0).compress(Bitmap.CompressFormat.JPEG, 100, outputStream); //para la calidad y compresi??n del archivo
        if (saved){
            //Toast.makeText(this, "Registro realizado OK!", Toast.LENGTH_SHORT).show();
        }

        if (outputStream != null){
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file != null){
            MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null, null);
        }

    }
    /*
     * implementacion permisos de almacenamiento y guardado de fotos
     */


    /**
     * M??todo para almacenar foto fisicamente
     */
    public void guardarFoto2(){ //Android Q y posteriores
        OutputStream outputStream = null;
        File file = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){ //versiones recientes
            ContentResolver resolver = getContentResolver(); //para manejar los values
            ContentValues values = new ContentValues(); //metadatos de imagenes tipo, render, etc

            SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
            String tiempo = formatter.format(new Date());

            //agrego el due??o de la foto
            String filename = codfoto + "@foto2" + "@" + tiempo;

            values.put(MediaStore.Images.Media.DISPLAY_NAME, filename);
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/MyApp");
            values.put(MediaStore.Images.Media.IS_PENDING, 1); //1 la imagen se esta procesando

            Uri collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY); //construir una ruta en android
            Uri imageUri = resolver.insert(collection, values); //insertando en memoria la ruta anterior


            try {
                outputStream = resolver.openOutputStream(imageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            values.clear();
            values.put(MediaStore.Images.Media.IS_PENDING, 0);
            resolver.update(imageUri, values, null, null);
        }
        else{ //Apis mas antiguas < 28
            String imageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();

            SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
            String tiempo = formatter.format(new Date());

            //agrego el due??o de la foto
            String filename = codfoto + "@foto2" + "@" + tiempo + ".jpg"; //nombre del archivo

            file = new File(imageDir, filename);

            try {
                outputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        boolean saved = listaFotos.get(1).compress(Bitmap.CompressFormat.JPEG, 100, outputStream); //para la calidad y compresi??n del archivo
        if (saved){
            //Toast.makeText(this, "Registro OK", Toast.LENGTH_SHORT).show();
        }

        if (outputStream != null){
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file != null){
            MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null, null);
        }

        archivos();
    }

    private File[] archivos() {
        File ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File fotos[] = ruta.listFiles();
        return fotos;
    }

    /*
     * implementacion permisos de almacenamiento y guardado de fotos
     */



    /*
     * implementacion preguntar por permisos de camara y almacenamiento
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_CAMERA){
            if (permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                tomarFoto();
            } //puede ir un else indicando que no se aceptaron los permisos
        }
        else if(requestCode == REQUEST_PERMISSION_WRITE_STORAGE){
            if (permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                guardarFoto1();
                guardarFoto2();
            } //puede ir un else indicando que no se aceptaron los permisos
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    /*
     * implementacion preguntar por permisos de camara y almacenamiento
     */

    /*
     * implementacion de Camara
     */



    /*
     * implementacion de NavigationDrawer
     */

    /**
     * m??todo para aplicar toogle
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toogle.onConfigurationChanged(newConfig);
    }

    /**
     * M??todo para sincronizar toogle
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toogle.syncState();
    }

    /**
     * m??todo para activar icono sanwich en NavigationDrawer
     * @return
     */
    private ActionBarDrawerToggle setDrawerToogle() {
        return new ActionBarDrawerToggle(this, myDrawerLayout, myToolbar, R.string.drawer_open, R.string.drawer_close);
    }

    /**
     * m??todo para detectar click en el icono sandwich
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //para mostrar los fragmentos
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (item.getItemId()) {
            case R.id.nav_registrar:
                ft.replace(R.id.FrameLayout, new FragRegistrarEquipos()).commit();
                break;
            case R.id.nav_ver:
                ft.replace(R.id.FrameLayout, new FragMostrarEquipos()).commit();
                break;
            case R.id.nav_eliminar:
                ft.replace(R.id.FrameLayout, new FragEliminarRegistro()).commit();
                break;
        }
        setTitle(item.getTitle() + " - " + nombre); //para mostrar el t??tulo
        myDrawerLayout.closeDrawers(); //para cerrar drawer
        return true;
    }
}