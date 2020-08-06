package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.booklist.interfaces.OnBookClickListener;
import com.example.booklist.model.BooksModels;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BookAdapter adapter;
    private ArrayList<BooksModels> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        list.add(new BooksModels(
                "«Стив Джобс» Биография",
                "«Биография сооснователя корпорации Apple Стива Джобса, " +
                        "написанная американским журналистом и биографом Уолтером Айзексоном " +
                        "и опубликованная издательством «Simon & Schuster». Айзексон работал над книгой около трёх лет. "));
        list.add(new BooksModels(
                "JAVA. Полное руководство. " +
                        "Десятое издание. " +
                        "Техническая литература",
                        "В этом десятом издании справочного пособия, " +
                        "полностью обновленном с учетом последней версии Java SE 9, " +
                        "поясняется, как разрабатывать, компилировать, " +
                        "отлаживать и выполнять программы на языке программирования Java. " +
                        "Это пособие составлено Гербертом Шилдтом, автором популярных во всем мире книг по языкам программирования, " +
                        "таким образом, чтобы охватить все языковые средства Java, " +
                        "включая синтаксис, ключевые слова, основные принципы объектно-ориентированного программирования, " +
                        "значительную часть прикладного интерфейса Java API, библиотеки классов, аплеты и сервлеты, " +
                        "компоненты JavaBeans, библиотеки AWT и Swing, а также продемонстрировать их применение на простых и наглядных примерах. " +
                        "Не обойдены вниманием и новые средства, появившиеся в версии Java SE 9, в том числе модули и утилита JShell."));
        list.add(new BooksModels(
                "Литература по саморазвитию",
                "Излагаются секреты лидерской мудрости легендарного исторического деятеля Японии XVI века Тоётоми Хидэёси," +
                        " которые с успехом могут быть применены в ХХІ веке."));
        list.add(new BooksModels(
                "«Как завоёвывать друзей и оказывать влияние на людей»",
                "Наиболее известная книга Дейла Карнеги, " +
                        "вышедшая 12 ноября 1936 года и изданная на многих языках мира. " +
                        "Книга представляет собой собрание практических советов и жизненных историй."));
        list.add(new BooksModels(
                "Nike – один из самых узнаваемых мировых брендов. Биография",
                        "Создатель компании – Фил Найт – один из богатейших людей, " +
                        "хотя еще в юности он не мог себе позволить купить кроссовки Adidas. " +
                        "50 лет назад студент Орегонского университета и бегун на средние дистанции " +
                        "Фил Найт занял у отца 50 баксов и начал перепродавать кроссовки из Японии. " +
                        "Сегодня годовой оборот компании Nike составляет 30 миллиардов долларов. " +
                        "А пара «найков» найдется в шкафу у каждого – от президента до подростка." +
                        "Фил Найт – человек-загадка, он редко дает интервью. Эта книга – исповедь о создании компании, "));

        adapter = new BookAdapter(list);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

        adapter.setOnBookClickListener(new OnBookClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("position", list.get(position));
                BookInfoFragment fragment = new BookInfoFragment();
                fragment.setArguments(bundle);
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fr_container, fragment)
                        .addToBackStack(null).commit();
            }
        });
    }
}
