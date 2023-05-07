package com.example.sweep.screens.account.subpages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun Profile(paddingValues: PaddingValues) {
  Surface(
    color = MaterialTheme.colorScheme.background,
    modifier = Modifier
      .fillMaxSize()
      .padding(paddingValues = paddingValues),
  ) {
    BoxWithConstraints {
      Column {
        Box(
          contentAlignment = Alignment.TopCenter,
          modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp)
            .clip(MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.onBackground)
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
              .padding(all = 10.dp),
          ) {
            InputTextFirstName()
            InputTextLastName()
            InputTextNickname()
            InputTextDOB()
            MyButton(onClick = {})
          }
        }

        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(
              top = 0.dp,
              bottom = 20.dp,
              end = 20.dp,
              start = 20.dp
            )
            .clip(MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.onBackground)
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
              .padding(all = 10.dp),
          ) {
//            Text(text = "First Name")
            EditEmailSection()
            Divider()
            EditPhoneNumberSection()
          }
        }

        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(
              top = 0.dp,
              bottom = 20.dp,
              end = 20.dp,
              start = 20.dp
            )
            .clip(MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.onBackground)
        ) {
          Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
              .padding(all = 10.dp),
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
            ) {
              Icon(
                imageVector = Icons.Default.Key,
                contentDescription = "Build Icon",
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                  .size(20.dp)
              )
              Spacer(modifier = Modifier.width(10.dp))

              Text(
                text = "Change Password",
                modifier = Modifier
                  .align(Alignment.CenterVertically)
                  .padding(5.dp),
              )
            }
            Divider()
            Row(
              verticalAlignment = Alignment.CenterVertically,
            ) {
              Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Build Icon",
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                  .size(20.dp)
              )
              Spacer(modifier = Modifier.width(10.dp))

              Text(
                text = "Delete Account",
                modifier = Modifier
                  .align(Alignment.CenterVertically)
                  .padding(5.dp),
              )
            }
          }
        }

        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(
              top = 0.dp,
              bottom = 20.dp,
              end = 20.dp,
              start = 20.dp
            )
            .clip(MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.onBackground)
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
              .padding(all = 10.dp),
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
            ) {
              Icon(
                imageVector = Icons.Default.Logout,
                contentDescription = "Build Icon",
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                  .size(20.dp)
              )
              Spacer(modifier = Modifier.width(10.dp))

              Text(
                text = "Sign Out",
                modifier = Modifier
                  .align(Alignment.CenterVertically)
                  .padding(10.dp)
              )
            }
          }
        }
      }
    }
  }
}

@Composable
fun InputTextFirstName() {
  var firstname by remember { mutableStateOf("") }
  OutlinedTextField(
//    value = firstname,
    value = "Jamil",
//    onValueChange = { firstname = it }
    onValueChange = {},
    label = {
      Text("First Name") // should be the person's first name
    },
    modifier = Modifier
      .fillMaxWidth(),
  )
}

@Composable
fun InputTextLastName() {
  var lastname by remember { mutableStateOf("") }
  OutlinedTextField(
//    value = lastname,
    value = "Shoujah",
//    onValueChange = { lastname = it },
    onValueChange = {},
    label = {
      Text("Last Name")
    },
    modifier = Modifier
      .fillMaxWidth(),
  )
}

@Composable
fun InputTextNickname() {
  var nickname by remember { mutableStateOf("") }
  OutlinedTextField(
//    value = nickname,
    value = "ЯΛVΛGΣ",
//    onValueChange = { nickname = it },
    onValueChange = {},
    label = {
      Text("Nickname")
    },
    modifier = Modifier
      .fillMaxWidth(),
  )
}

@Composable
fun InputTextDOB() {
  var dob by remember { mutableStateOf("") }
  OutlinedTextField(
//    value = dob,
    value = "2001-09-03",
//    onValueChange = { dob = it },
    onValueChange = {},
    label = {
      Text("Date-of-Birth")
    },
    modifier = Modifier
      .fillMaxWidth(),
  )
}

@Composable
fun MyButton(onClick: () -> Unit) {
  Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
      containerColor = MaterialTheme.colorScheme.onSecondary,
    ),
    shape = MaterialTheme.shapes.small,
    modifier = Modifier
      .height(50.dp)
      .fillMaxWidth(),
  ) {
    Text(text = "Save", color = MaterialTheme.colorScheme.onBackground)
  }
}

@Composable
fun EditButton() {
  IconButton(onClick = { /*TODO*/ }) {
    Icon(
      modifier = Modifier
        .padding(10.dp),
      imageVector = Icons.Default.Edit,
      contentDescription = "Edit Icon",
      tint = MaterialTheme.colorScheme.onSecondary,
    )
  }
}

@Composable
fun EditEmailSection() {
  Row(modifier = Modifier.fillMaxWidth()) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(text = "jamilshoujah@gmail.com")
      Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier.fillMaxWidth()
      ) {
        EditButton()
      }
    }
  }
}

@Composable
fun EditPhoneNumberSection() {
  Row(modifier = Modifier.fillMaxWidth()) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(text = "+961 70 565 932")
      Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier.fillMaxWidth()
      ) {
        EditButton()
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
  SweepTheme {
    Profile(paddingValues = PaddingValues())
  }
}
