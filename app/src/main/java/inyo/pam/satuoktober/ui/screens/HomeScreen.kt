package inyo.pam.satuoktober.ui.screens

import androidx.compose.foundation.Image
import inyo.pam.satuoktober.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import inyo.pam.satuoktober.ui.home.HomeUiState

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onOpenDetail: (Int) -> Unit,
    onOpenProfile: () -> Unit,
    onOpenAbout: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Home",
                fontSize = 24.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier
                    .padding(8.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = RectangleShape
                    )
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Daftar Mahasiswa:", fontSize = 16.sp)
                    when {
                        uiState.isLoading -> {
                            Text("Loading...")
                        }
                        uiState.errorMessage != null -> {
                            Text(uiState.errorMessage, color = MaterialTheme.colorScheme.error)
                        }
                        uiState.students.isEmpty() -> {
                            Text("Tidak ada data mahasiswa")
                        }
                        else -> {
                            LazyColumn(
                                modifier = Modifier.heightIn(max = 180.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                items(uiState.students) { student ->
                                    Button(
                                        onClick = { onOpenDetail(student.id) },
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color(0xFFab3842)
                                        )
                                    ) {
                                        Text("${student.name} (${student.id})")
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = RectangleShape
                    )
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = onOpenProfile,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFab3842)
                        )
                    ) {
                        Text("Profile")
                    }

                    Button(
                        onClick = onOpenAbout,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFab3842)
                        )
                    ) {
                        Text("About")
                    }
                }
            }
        }
    }
}
