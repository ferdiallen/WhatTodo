package com.example.whattodo.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DriveFileRenameOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whattodo.R
import com.example.whattodo.core.poppins
import com.example.whattodo.core.spacing
import com.example.whattodo.data.model.TaskModel
import com.example.whattodo.ui.theme.ChipGreenColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
    onGoToDetailTask: (Int) -> Unit, onCreateNewTask: () -> Unit
) {
    val taskData by viewModel.taskData.collectAsState(emptyList())
    val numberOfData = remember(taskData) {
        derivedStateOf {
            taskData.size
        }
    }
    Scaffold(
        modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onCreateNewTask.invoke() },
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(50.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.DriveFileRenameOutline,
                            contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.mediumSpacing + 4.dp))
                Text(
                    text = stringResource(R.string.what_to_do_title), fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppins
                )
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.todo),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    fontFamily = poppins
                )
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.mediumSpacing + 4.dp))
                Card(modifier = Modifier.size(35.dp)) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = "${numberOfData.value}", fontWeight = FontWeight.SemiBold,
                            fontFamily = poppins
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(taskData) {
                    key(it.id) {
                        TaskItem(
                            Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            it, clickedItem = {}
                        )

                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumSpacing + 4.dp))
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TaskItem(
    modifier: Modifier = Modifier,
    data: TaskModel,
    clickedItem: () -> Unit
) {
    Card(onClick = {
        clickedItem()
    }, modifier, shape = RoundedCornerShape(32.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Row() {
                Text(
                    text = data.taskName,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold, maxLines = 2,
                    overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(2F),
                    fontFamily = poppins
                )
                Spacer(modifier = Modifier.weight(0.5F))
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
            Text(
                text = data.description,
                fontSize = 20.sp,
                fontWeight = FontWeight.Thin,
                color = Color.Gray,
                fontFamily = poppins
            )
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                Card(
                    modifier = Modifier
                        .wrapContentSize(), colors = CardDefaults.cardColors(
                        containerColor = ChipGreenColor
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = data.dueDate, fontWeight = FontWeight.SemiBold, maxLines = 1,
                            fontFamily = poppins, fontSize = 13.sp, color = Color.White
                        )
                    }
                }
            }
        }
    }
}