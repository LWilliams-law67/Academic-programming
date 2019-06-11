/*
 *      File  : PatientList.cpp
 *      Author: Ricky Landry (rlandry)
 *      Course: COP3014
 *      Proj  : Project 02
 *      Descr : The definition of the class that contains the initialized list
 *              of patients available to be scheduled for the day.
 */

#include "PatientList.h"

Patient PatientList::patients[] = { {"Alan Harry",            24, "Male"},
                                    {"Ching Peppard",         32, "Male"},
                                    {"Lorelei Saad",          18, "Female"},
                                    {"Phoebe Schild",         23, "Female"},
                                    {"Tomasa Smither",        41, "Male"},
                                    {"Jessie Denicola",       40, "Female"},
                                    {"Keenan Hershberger",    69, "Male"},
                                    {"Apolonia Axtell",       52, "Other"},
                                    {"Bessie Boller",         78, "Female"},
                                    {"Logan Beverage",        64, "Male"},
                                    {"Toby Dill",             58, "Male"},
                                    {"Bryanna Luft",          67, "Female"},
                                    {"Fernande Weatherman",   74, "Male"},
                                    {"Marcell Coombes",       65, "Male"},
                                    {"Fidelia Vannest",       81, "Other"},
                                    {"Jaleesa Sylvest",       41, "Female"},
                                    {"Kelsie Watson",         61, "Female"},
                                    {"Analisa Manser",        39, "Female"},
                                    {"Pansy Haddock",         74, "Male"},
                                    {"Ervin Boltz",           26, "Male"},
                                    {"Brigida Huang",         38, "Female"},
                                    {"Tamie Magno",           46, "Female"},
                                    {"Marquerite Jozwiak",    16, "Female"},
                                    {"Mazie Hagwood",         70, "Other"},
                                    {"Alan Peppard",          24, "Male"},
                                    {"Ching Saad",            32, "Male"},
                                    {"Lorelei Schild",        18, "Female"},
                                    {"Phoebe Smither",        23, "Female"},
                                    {"Tomasa Denicola",       41, "Male"},
                                    {"Jessie Hershberger",    40, "Female"},
                                    {"Keenan Axtell",         69, "Male"},
                                    {"Apolonia Boller",       52, "Other"},
                                    {"Bessie Beverage",       78, "Female"},
                                    {"Logan Dill",            64, "Male"},
                                    {"Toby Luft",             58, "Male"},
                                    {"Bryanna Weatherman",    67, "Female"},
                                    {"Fernande Coombes",      74, "Male"},
                                    {"Marcell Vannest",       65, "Male"},
                                    {"Fidelia Sylvest",       81, "Other"},
                                    {"Jaleesa Watson",        41, "Female"},
                                    {"Kelsie Manser",         61, "Female"},
                                    {"Analisa Haddock",       39, "Female"},
                                    {"Pansy Boltz",           74, "Male"},
                                    {"Ervin Huang",           26, "Male"},
                                    {"Brigida Magno",         38, "Female"},
                                    {"Tamie Jozwiak",         46, "Female"},
                                    {"Marquerite Hagwood",    16, "Female"},
                                    {"Mazie Harry",           70, "Other"} };

const int PatientList::size = sizeof(patients)/sizeof(Patient);
