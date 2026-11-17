package inyo.pam.satuoktober.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import inyo.pam.satuoktober.data.repository.StudentRepository

class HomeViewModel(
    private val repository: StudentRepository
) : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set

    init {
        loadStudents()
    }

    fun loadStudents() {
        try {
            val students = repository.getStudents()
            uiState = HomeUiState(students = students)
        } catch (e: Exception) {
            uiState = HomeUiState(errorMessage = e.message ?: "Gagal memuat data mahasiswa")
        }
    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(repository) as T
                }
            }
    }
}
