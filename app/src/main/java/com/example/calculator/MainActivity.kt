package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    calculatorApp()
                }
            }
        }
    }
}

@Composable
fun calculatorApp(modifier: Modifier = Modifier)
{
    var displayvalue by remember{ mutableStateOf("") }


    Column (modifier = Modifier){

        Row {
            Text(text = displayvalue)
        }

        Row {
            Button(onClick = {
                displayvalue += "1"
            })
            {
                Text(text = "1")
            }


            Button(onClick = {
                displayvalue += "2"
            })
            {
                Text(text = "2")
            }
            Button(onClick = {
                displayvalue += "3"
            })
            {
                Text(text = "3")
            }
            Button(onClick = {
                displayvalue += "+"
            })
            {
                Text(text = "+")
            }
        }
        Row{
            Button(onClick = {
                displayvalue += "4"
            })
            {
                Text(text = "4")
            }
            Button(onClick = {
                displayvalue += "5"
            })
            {
                Text(text = "5")
            }
            Button(onClick = {
                displayvalue += "6"
            })
            {
                Text(text = "6")
            }
            Button(onClick = {
                displayvalue += "-"
            })
            {
                Text(text = "-")
            }
        }
        Row {
            Button(onClick = {
                displayvalue += "7"
            })
            {
                Text(text = "7")
            }
            Button(onClick = {
                displayvalue += "8"
            })
            {
                Text(text = "8")
            }
            Button(onClick = {
                displayvalue += "9"
            })
            {
                Text(text = "9")
            }

            Button(onClick = {
                val strs = displayvalue.split("+","-", ignoreCase = true)
                var total = 0;
                for (number in strs)
                {
                    total += number.toInt()
                }
                displayvalue = total.toString()
            })
            {
                Text(text = "=")
            }
        }
        Row {
            Button(
                modifier = modifier,
                onClick = { displayvalue += "0"})
            {
                Text(text = "0")
            }
            Button(onClick = {
                displayvalue = ""
            })
            {
                Text(text = "clear")
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun calculatorAppPreview() {
    calculatorApp()
}