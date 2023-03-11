package com.example.my_smail_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // создание полей для вывода на экран нужных значений

    private TextView textCount; // окно вывода значения счётчика
    private Button button; // кнопка счётчика
    private int count = 0; // переменная счётчика
    private ImageView mImageView;
    private static final String KEY_COUNT = "COUNT"; // создаем ключ хранения данных

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

           // присваивание переменным активити элементов представления activity_main
        textCount = findViewById(R.id.textCount);

        button = findViewById(R.id.button);

        // выполнение действий при нажатии кнопки

        button.setOnClickListener(listener);
        super.onCreate(savedInstanceState);
   }      // объект обработки нажатия кнопки (слушатель)




    private View.OnClickListener listener = new View.OnClickListener() {
      @Override
      public void onClick(View view) {

          if (count < 10) {

              // инкрементирование счётчика
              count++;
              textCount.setText(Integer.toString(count));

          } else {

              Toast toast = Toast.makeText(getApplicationContext(), "ЗАДАЧА ВЫПОЛНЕНА", Toast.LENGTH_SHORT); // инициализация
              toast.setGravity(Gravity.CENTER, 0, 0); // задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
              // помещение тоста в контейнер
              LinearLayout toastContainer = (LinearLayout) toast.getView();
              // добавление в тост картинки
              ImageView w = new ImageView(getApplicationContext()); // создание объекта картинки (контекст)
              w.setImageResource(R.drawable.w); // добавление картинки из ресурсов
              toastContainer.addView(w, 0); // добавление картинки под индексом 1 в имеющийся контейнер
              toast.show(); // демонстрация тоста на экране
          }
      }
    };
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) { // Сохранение состояния count онo будет передана в методу onCreate и onRestoreInstanceState() при закрытии и повторном запуске процесса.
        savedInstanceState.putInt(KEY_COUNT, count);
        super.onSaveInstanceState(savedInstanceState);
   }

    @Override
    protected void onStart() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, "Старт активности", Toast.LENGTH_SHORT); // инициализация
        toast.show(); // демонстрация тоста на экране
        super.onStart();
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) { //для восстанавления сохранённых значений из метода onSaveInstanceState().

        count = savedInstanceState.getInt(KEY_COUNT);
        textCount.setText(Integer.toString(count));
        super.onRestoreInstanceState(savedInstanceState);
    }
       @Override
    protected void onResume() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, "Взаимодействие с пользователем", Toast.LENGTH_SHORT); // инициализация
        toast.setGravity(Gravity.CENTER, 0,0); // задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
        // помещение тоста в контейнер
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        // добавление в тост картинки
        ImageView i = new ImageView(this); // создание объекта картинки (контекст)
        i.setImageResource(R.drawable.i); // добавление картинки из ресурсов
        toastContainer.addView(i, 0); // добавление картинки под индексом 1 в имеющийся контейнер
        toast.show(); // демонстрация тоста на экране
        super.onResume();
    }

        @Override
    protected void onPause() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, "Пауза активности", Toast.LENGTH_SHORT); // инициализация
        toast.setGravity(Gravity.TOP, 0,0); // задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
        toast.show(); // демонстрация тоста на экране
        super.onPause();
    }
    @Override
    protected void onStop() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, "Стоп активности", Toast.LENGTH_SHORT); // инициализация
        toast.setGravity(Gravity.LEFT, 0,0); // задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
        toast.show(); // демонстрация тоста на экране
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, "Уничтожение активности", Toast.LENGTH_SHORT); // инициализация
        toast.setGravity(Gravity.BOTTOM, 0,0); // задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
        toast.show(); // демонстрация тоста на экране
        super.onDestroy();
    }

}