package com.example.ageinminuteapp

object Constants {
	fun getQuestions(): ArrayList<Question> {
		return arrayListOf<Question>(
			Question(
				12341, "Kujt shteti i përket ky imazh?", R.drawable.ic_flag_of_argentina,

				"Gjermani", "Argjentine", "Brazil", "New York", 1
			),
			Question(
				12342, "Kujt shteti i përket ky imazh?", R.drawable.ic_flag_of_australia,
				"Australi", "Amerike", "Zelande e re", "Jamaica", 0
			),
			Question(
				12343, "Kujt shteti i përket ky imazh?", R.drawable.ic_flag_of_belgium,
				"Gjermani", "Belgjikë", "Itali", "Spanjë", 1
			),
			Question(
				12344, "Kujt shteti i përket ky imazh?", R.drawable.ic_flag_of_brazil,
				"Shqipëri", "Kuwait", "Iran", "Brazil", 2
			),
			Question(
				12345, "Kujt shteti i përket ky imazh?", R.drawable.ic_flag_of_denmark,
				"Norvegji", "Danimarkë", "Finlandë","Azerbaijan", 1
			),
			Question(
				12346, "Kujt shteti i përket ky imazh?", R.drawable.ic_flag_of_fiji,
				"Togo", "Kongo", "Madagaskar", "Fiji", 3
			), Question(
				12347, "Kujt shteti i përket ky imazh?", R.drawable.ic_flag_of_india,

				"Iran",
				"Irak",
				"Indi",
				"Bangladesh", 2
			), Question(
				12348, "Kujt shteti i përket ky imazh?", R.drawable.ic_flag_of_germany,
				"Gjermani", "Hollandë", "Rusi", "Kosovë", 0
			),
			Question(
				12349, "Kujt shteti i përket ky imazh?", R.drawable.ic_flag_of_new_zealand,
				"Tirana", "Dublin", "Washington", "Zelande e re", 2
			)


		)
	}
}