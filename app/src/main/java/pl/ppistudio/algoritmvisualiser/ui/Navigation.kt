package pl.ppistudio.algoritmvisualiser.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import pl.ppistudio.algoritmvisualiser.ui.screens.SettingsScreen
import pl.ppistudio.algoritmvisualiser.ui.screens.SortingScreen
import pl.ppistudio.algoritmvisualiser.view_models.SortingViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "onboarding"
    ) {
        navigation(
            startDestination = "sorting",
            route = "onboarding"
        ) {
            composable("sorting") { entry ->
                val viewModel = entry.sharedViewModel<SortingViewModel>(navController,)

                SortingScreen(
                    items = viewModel.items,
                    flow = viewModel.sortingStrategy.flow,

                    onNavigate = {
                        navController.navigate("settings")
                    },

                    sortTrigger = viewModel.sortTrigger,
                    toggleSort = {
                        viewModel.toggleSort()
                    },

                    setItems = {
                        viewModel.items = it
                    },

                    finishSorting = {
                        viewModel.sortTrigger = false
                    }
                )
            }
            composable("settings") { entry ->
                val viewModel = entry.sharedViewModel<SortingViewModel>(navController)

                SettingsScreen(
                    onSetRandomNumbers = {
                        viewModel.setRandomNumbers()
                    },
                    setSortingStrategy = {
                        viewModel.setSortingStrategy(it)
                    }
                )
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController,
): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}