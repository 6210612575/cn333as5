package com.example.phonebook

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynotes.ui.theme.MyNotesTheme
import com.example.mynotes.ui.theme.MyNotesThemeSettings
import com.example.phonebook.routing.MyNotesRouter
import com.example.phonebook.routing.Screen
import com.example.phonebook.screens.MainScreen
import com.example.phonebook.screens.SaveNumberScreen
import com.example.phonebook.viewmodel.MainViewModel
import com.example.phonebook.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNotesTheme(darkTheme = MyNotesThemeSettings.isDarkThemeEnabled) {
                val viewModel: MainViewModel = viewModel(
                    factory = MainViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                MainActivityScreen(viewModel)
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MainActivityScreen(viewModel: MainViewModel) {
    Surface {
        when (MyNotesRouter.currentScreen) {
            is Screen.Notes -> MainScreen(viewModel)
            is Screen.SaveNumber -> SaveNumberScreen(viewModel)
        }
    }
}
