package com.example.myapplication.di.scopes;

import javax.inject.Scope;

import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerView