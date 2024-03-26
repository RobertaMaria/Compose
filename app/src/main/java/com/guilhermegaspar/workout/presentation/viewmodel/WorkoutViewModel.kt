package com.guilhermegaspar.workout.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guilhermegaspar.workout.domain.usecase.WorkoutExerciseUseCase
import com.guilhermegaspar.workout.domain.usecase.WorkoutImageUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class WorkoutViewModel(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val useCase: WorkoutExerciseUseCase,
    private val imageUseCase: WorkoutImageUseCase
): ViewModel() {
    private val _state = MutableStateFlow<WorkoutUiState>(WorkoutUiState())
    val state: StateFlow<WorkoutUiState> = _state

    fun getExercise(){
        viewModelScope.launch {
            useCase.invoke()
                .flowOn(dispatcher)
                .collect{
                    val currentValue = checkNotNull(
                        state.value.copy()
                    )
                    _state.value = currentValue.copy(
                        list = it.exercise
                    )
                }
        }
    }

    fun getExerciseImage(){
        viewModelScope.launch {
            imageUseCase.invoke()
                .flowOn(dispatcher)
                .collect{
                    val currentValue = checkNotNull(
                        state.value.copy()
                    )
                    _state.value = currentValue.copy(
                        imageList = it.result
                    )
                }
        }
    }
}