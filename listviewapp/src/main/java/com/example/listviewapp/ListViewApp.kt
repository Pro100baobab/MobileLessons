package com.example.listviewapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewapp.databinding.ActivityListViewAppBinding
import com.example.historyevents.HistoryEventsApp

class ListViewApp : AppCompatActivity() {

    private lateinit var binding: ActivityListViewAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.intentButton1.setOnClickListener {
            val intent: Intent = Intent(this, HistoryEventsApp::class.java)
            startActivity(intent)
            finish()
        }

        val books = listOf(
            "Михаил Булгаков — Мастер и Маргарита",
            "Лев Толстой — Война и мир",
            "Фёдор Достоевский — Преступление и наказание",
            "Антон Чехов — Рассказы",
            "Александр Пушкин — Евгений Онегин",
            "Иван Тургенев — Отцы и дети",
            "Николай Гоголь — Мёртвые души",
            "Максим Горький — На дне",
            "Михаил Лермонтов — Герой нашего времени",
            "Александр Грибоедов — Горе от ума",
            "Джордж Оруэлл — 1984",
            "Джордж Оруэлл — Скотный двор",
            "Олдос Хаксли — О дивный новый мир",
            "Рэй Брэдбери — 451 градус по Фаренгейту",
            "Эрнест Хемингуэй — Старик и море",
            "Фрэнсис Скотт Фицджеральд — Великий Гэтсби",
            "Джек Лондон — Мартин Иден",
            "Джек Лондон — Белый клык",
            "Марк Твен — Приключения Тома Сойера",
            "Роберт Льюис Стивенсон — Остров сокровищ",
            "Даниэль Дефо — Робинзон Крузо",
            "Жюль Верн — Двадцать тысяч лье под водой",
            "Жюль Верн — Таинственный остров",
            "Артур Конан Дойл — Приключения Шерлока Холмса",
            "Агата Кристи — Убийство в Восточном экспрессе",
            "Агата Кристи — Десять негритят",
            "Стивен Кинг — Оно",
            "Стивен Кинг — Зелёная миля",
            "Уильям Шекспир — Гамлет",
            "Уильям Шекспир — Ромео и Джульетта",
            "Габриэль Гарсиа Маркес — Сто лет одиночества",
            "Пауло Коэльо — Алхимик",
            "Виктор Гюго — Собор Парижской Богоматери",
            "Александр Дюма — Граф Монте-Кристо",
            "Александр Дюма — Три мушкетёра",
            "Герман Гессе — Степной волк",
            "Франц Кафка — Процесс",
            "Рэй Брэдбери — Марсианские хроники",
            "Джон Стейнбек — О мышах и людях",
            "Умберто Эко — Имя розы"
        )

        val listView = binding.listView
        listView.adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, books
        )
    }
}