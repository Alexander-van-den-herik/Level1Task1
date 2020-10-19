package nl.herika.app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_higher_lower.view.*
import nl.herika.level1task1.R
import nl.herika.level1task1.databinding.ActivityHigherLowerBinding
import kotlin.math.log

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var diceRole: Int = 1

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHigherLowerBinding.inflate(layoutInflater)

        setContentView(binding.root)

        changeUI(diceRole)

        binding.ButtonPannel.LowerBtn.setOnClickListener {
            checkAnswer(Bet.Lower)
        }
        binding.ButtonPannel.EquelsBtn.setOnClickListener {
            checkAnswer(Bet.Equels)
        }
        binding.ButtonPannel.HigherBtn.setOnClickListener {
            checkAnswer(Bet.Higher)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun checkAnswer(answer: Bet) {
        var boolean: Boolean = false
        val oldDice = diceRole
        if (answer == Bet.Lower) {
            boolean = oldDice > roleDice()
        }
        if (answer == Bet.Equels) {
            boolean = oldDice == roleDice()
        }
        if (answer == Bet.Higher) {
            boolean = oldDice < roleDice()
        }
        println(boolean)
        if (boolean) {
            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show();
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun roleDice(): Int {
        diceRole = (1..6).random()
        changeUI(diceRole)
        return diceRole
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun changeUI(diceRole: Int) {
        binding.ThrowValue.text = diceRole.toString()
        if (diceRole == 1) {
            binding.DiceRole.setImageDrawable(getDrawable(R.mipmap.dice1))
        }
        if (diceRole == 2) {
            binding.DiceRole.setImageDrawable(getDrawable(R.mipmap.dice2))
        }
        if (diceRole == 3) {
            binding.DiceRole.setImageDrawable(getDrawable(R.mipmap.dice3))
        }
        if (diceRole == 4) {
            binding.DiceRole.setImageDrawable(getDrawable(R.mipmap.dice4))
        }
        if (diceRole == 5) {
            binding.DiceRole.setImageDrawable(getDrawable(R.mipmap.dice5))
        }
        if (diceRole == 6) {
            binding.DiceRole.setImageDrawable(getDrawable(R.mipmap.dice6))
        }
    }
}

enum class Bet {
    Lower,
    Equels,
    Higher
}
