package com.example.historyevents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.historyevents.databinding.ActivityHistoryEventsAppBinding

class HistoryEventsApp : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryEventsAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistoryEventsAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val events = listOf(
            HistoryEvent(
                "Строительство Великой Китайской стены",
                "VII век до н. э. — XVII век",
                "Система оборонительных сооружений создавалась и перестраивалась разными китайскими государствами и династиями.",
                R.drawable.great_wall_of_china_july_2006
            ),
            HistoryEvent(
                "Демократия в Афинах",
                "V век до н. э.",
                "В Афинах сформировалась одна из наиболее известных ранних форм демократии, в которой граждане участвовали в принятии решений.",
                R.drawable.parthenon_from_west
            ),
            HistoryEvent(
                "Открытие Колизея",
                "80 год н. э.",
                "В Риме открылся большой амфитеатр, предназначенный для общественных зрелищ.",
                R.drawable.colosseum_in_rome
            ),
            HistoryEvent(
                "Изобретение книгопечатания Гутенбергом",
                "Около 1450 года",
                "Печатание подвижными металлическими литерами помогло значительно ускорить производство книг в Европе.",
                R.drawable.gutenberg_bible
            ),
            HistoryEvent(
                "Начало Французской революции",
                "1789 год",
                "Революция привела к глубоким политическим и общественным преобразованиям во Франции.",
                R.drawable.prise_de_la_bastille
            ),
            HistoryEvent(
                "Провозглашение независимости США",
                "1776 год",
                "Тринадцать британских колоний в Северной Америке приняли Декларацию независимости.",
                R.drawable.declaration_of_independence__1819___by_john_trumbull
            ),
            HistoryEvent(
                "Первый полёт братьев Райт",
                "1903 год",
                "Орвилл и Уилбур Райт совершили один из первых успешных управляемых полётов на самолёте с двигателем.",
                R.drawable.wrightflyer
            ),
            HistoryEvent(
                "Начало Второй мировой войны",
                "1939 год",
                "Нападение Германии на Польшу 1 сентября стало началом войны в Европе.",
                R.drawable.ww2
            ),
            HistoryEvent(
                "Падение Берлинской стены",
                "1989 год",
                "Открытие пограничных переходов стало важным символом завершения разделения Восточного и Западного Берлина.",
                R.drawable.west_and_east_germans_at_the_brandenburg_gate_in_1989
            ),
            HistoryEvent(
                "Первый искусственный спутник Земли",
                "1957 год",
                "СССР запустил «Спутник-1» — первый искусственный спутник Земли.",
                R.drawable.sputnik_asm
            ),
            HistoryEvent(
                "Первый полёт человека в космос",
                "1961 год",
                "Юрий Гагарин совершил орбитальный полёт вокруг Земли на корабле «Восток-1».",
                R.drawable.yuri_gagarin_in_sweden
            ),
            HistoryEvent(
                "Первая высадка человека на Луну",
                "1969 год",
                "В рамках миссии «Аполлон-11» Нил Армстронг и Базз Олдрин высадились на поверхности Луны.",
                R.drawable.apollo_11_bootprint
            )
        )

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = HistoryEventsAdapter(events)
    }
}