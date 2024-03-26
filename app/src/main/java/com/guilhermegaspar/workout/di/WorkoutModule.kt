package com.guilhermegaspar.workout.di

import com.guilhermegaspar.workout.data.datasource.WorkoutDataSource
import com.guilhermegaspar.workout.data.datasource.WorkoutDataSourceImp
import com.guilhermegaspar.workout.data.repository.WorkoutRepositoryImp
import com.guilhermegaspar.workout.data.retrofit.RetrofitConfig
import com.guilhermegaspar.workout.data.service.WorkoutService
import com.guilhermegaspar.workout.domain.repository.WorkoutRepository
import com.guilhermegaspar.workout.domain.usecase.WorkoutExerciseUseCase
import com.guilhermegaspar.workout.domain.usecase.WorkoutImageUseCase
import com.guilhermegaspar.workout.presentation.viewmodel.WorkoutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    factory<WorkoutRepository> {
        WorkoutRepositoryImp(
            dataSource = get()
        )
    }

    factory<WorkoutDataSource> {
        WorkoutDataSourceImp(
            service = get()
        )
    }

    factory<WorkoutService> {
        get<RetrofitConfig>().getRetrofitInstance().create(WorkoutService::class.java)
    }

    viewModel<WorkoutViewModel> { WorkoutViewModel(useCase = get(), imageUseCase = get()) }

    factory<WorkoutExerciseUseCase> { WorkoutExerciseUseCase(repository = get()) }
    factory<WorkoutImageUseCase> { WorkoutImageUseCase(repository = get()) }

    single { RetrofitConfig() }

}