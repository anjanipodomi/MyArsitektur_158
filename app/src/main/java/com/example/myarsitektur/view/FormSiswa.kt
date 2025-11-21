package com.example.myarsitektur.view
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.navigasiku.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    onSubmitBtnClick: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.home), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(250.dp),
                label = { Text(text = "Nama Lengkap") }
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // Radio button jenis kelamin
            Row(horizontalArrangement = Arrangement.Center) {
                jenisK.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedGender == item,
                            onClick = { selectedGender = item }
                        )
                        Text(text = item)
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                singleLine = true,
                modifier = Modifier.width(250.dp),
                label = { Text(text = "Alamat") }
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                onClick = onSubmitBtnClick
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}
