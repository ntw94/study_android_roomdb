package com.kr.ntw.myapplication.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.kr.ntw.myapplication.R
import com.kr.ntw.myapplication.model.Crime

class CrimeFragment : Fragment() {

    private lateinit var crime:Crime
    private lateinit var titleField:EditText
    private lateinit var dateButton:Button
    private lateinit var solvedCheckBox: CheckBox

    //여기에서는 인플레이트 하지 않음
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_crime,container,false)

        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as Button
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox

        dateButton.apply{
            text = crime.date.toString()
            isEnabled = false
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(sequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                crime.title = sequence.toString()
            }
            override fun afterTextChanged(p0: Editable?) {
            }

        }

        titleField.addTextChangedListener(titleWatcher)

        //나중에 이거 변형해서 해볼것
        solvedCheckBox.apply{
            setOnCheckedChangeListener { _, isChecked ->
                crime.isSolved = isChecked
            }
        }

    }
}