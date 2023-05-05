package com.example.phonebook

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phonebook.routing.MyPhoneRouter
import com.example.phonebook.routing.Screen
import com.example.phonebook.screens.PhoneScreen
import com.example.phonebook.screens.SavePhoneScreen
import com.example.phonebook.ui.theme.PhoneBookTheme
import com.example.phonebook.viewmodel.MainViewModel
import com.example.phonebook.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = viewModel(
                factory = MainViewModelFactory(LocalContext.current.applicationContext as Application)
            )
            MainActivityScreen(viewModel)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MainActivityScreen(viewModel: MainViewModel) {
    Surface {
        when (MyPhoneRouter.currentScreen) {
            is Screen.Phones -> PhoneScreen(viewModel)
            is Screen.SavePhone -> SavePhoneScreen(viewModel)
        }
    }
}