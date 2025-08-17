package com.kp.composearc.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.kp.composearc.data.model.FruitModel

class ListViewScreenViewModel : ViewModel(){
    val fruits = listOf(
        FruitModel("Apple",
            "https://upload.wikimedia.org/wikipedia/commons/1/15/Red_Apple.jpg",
            "A sweet, crisp fruit often red, green, or yellow in color.",
            "#FF0800"
        ),
        FruitModel("Banana",
            "https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg",
            "A soft, sweet fruit with a yellow peel, rich in potassium.",
            "#FFE135"
        ),
        FruitModel("Mango",
            "https://upload.wikimedia.org/wikipedia/commons/9/90/Hapus_Mango.jpg",
            "A tropical stone fruit known for its juicy, sweet flesh.",
            "#FFC324"
        ),
        FruitModel("Orange",
            "https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg",
            "A citrus fruit known for its bright color and tangy flavor.",
            "#FFA500"
        ),
        FruitModel("Grapes",
            "https://upload.wikimedia.org/wikipedia/commons/4/40/Table_grapes_on_white.jpg",
            "Small, sweet berries that grow in clusters and can be eaten fresh or used in wine.",
            "#6F2DA8"
        ),
        FruitModel("Pineapple",
            "https://upload.wikimedia.org/wikipedia/commons/c/cb/Pineapple_and_cross_section.jpg",
            "A tropical fruit with a spiky exterior and sweet, tangy flesh.",
            "#FFD93B"
        ),
        FruitModel("Watermelon",
            "https://upload.wikimedia.org/wikipedia/commons/f/fd/Watermelon_cross_BNC.jpg",
            "A large, juicy fruit with green rind and sweet red flesh.",
            "#FC6C85"
        ),
        FruitModel("Papaya",
            "https://upload.wikimedia.org/wikipedia/commons/7/7b/Papaya_cross_section.jpg",
            "A tropical fruit with sweet orange flesh and black seeds.",
            "#FF7518"
        ),
        FruitModel("Strawberry",
            "https://upload.wikimedia.org/wikipedia/commons/2/29/PerfectStrawberry.jpg",
            "A small, red fruit with a juicy texture and sweet flavor.",
            "#FC5A8D"
        ),
        FruitModel("Blueberry",
            "https://upload.wikimedia.org/wikipedia/commons/0/05/Blueberries.jpg",
            "Small, round berries with a sweet-tart taste and deep blue color.",
            "#4F86F7"
        ),
        FruitModel("Raspberry",
            "https://upload.wikimedia.org/wikipedia/commons/8/8d/Raspberry_pi.jpg",
            "A soft, red berry with a sweet-tart taste.",
            "#E30B5C"
        ),
        FruitModel("Cherry",
            "https://upload.wikimedia.org/wikipedia/commons/b/bb/Cherry_Stella444.jpg",
            "A small, round stone fruit with sweet or sour flavor.",
            "#DE3163"
        ),
        FruitModel("Peach",
            "https://upload.wikimedia.org/wikipedia/commons/9/9e/Autumn_Red_peach.jpg",
            "A soft, juicy fruit with fuzzy skin and sweet flavor.",
            "#FFE5B4"
        ),
        FruitModel("Plum",
            "https://upload.wikimedia.org/wikipedia/commons/f/f5/Plums.jpg",
            "A small stone fruit with smooth skin and sweet or tart taste.",
            "#8E4585"
        ),
        FruitModel("Pear",
            "https://upload.wikimedia.org/wikipedia/commons/0/0f/Pears.jpg",
            "A sweet fruit with a soft, grainy texture.",
            "#D1E231"
        ),
        FruitModel("Kiwi",
            "https://upload.wikimedia.org/wikipedia/commons/d/d3/Kiwi_aka.jpg",
            "A small, fuzzy brown fruit with bright green, tangy flesh.",
            "#8EE53F"
        ),
        FruitModel("Pomegranate",
            "https://upload.wikimedia.org/wikipedia/commons/0/07/Pomegranate.jpg",
            "A fruit filled with juicy, ruby-red seeds.",
            "#9B111E"
        ),
        FruitModel("Dragon Fruit",
            "https://upload.wikimedia.org/wikipedia/commons/e/ee/Pitaya_cross_section_ed2.jpg",
            "An exotic cactus fruit with vibrant skin and sweet, mild flesh.",
            "#FF1CAE"
        ),
        FruitModel("Guava",
            "https://upload.wikimedia.org/wikipedia/commons/a/a4/Guava_ID.jpg",
            "A tropical fruit with green skin and pink or white sweet flesh.",
            "#D4E157"
        ),
        FruitModel("Lychee",
            "https://upload.wikimedia.org/wikipedia/commons/0/05/Litchi_chinensis_fruits.JPG",
            "A small fruit with rough red skin and juicy white interior.",
            "#FF4F58"
        ),
        FruitModel("Apricot",
            "https://upload.wikimedia.org/wikipedia/commons/7/7b/Apricots.jpg",
            "A small, golden-orange fruit with smooth skin and sweet flesh.",
            "#FBCEB1"
        ),
        FruitModel("Blackberry",
            "https://upload.wikimedia.org/wikipedia/commons/5/59/Blackberries.jpg",
            "A dark, juicy berry with a sweet and tart taste.",
            "#4D0135"
        ),
        FruitModel("Cantaloupe",
            "https://upload.wikimedia.org/wikipedia/commons/3/36/Cantaloupe_and_cross_section.jpg",
            "A sweet melon with orange flesh and a netted rind.",
            "#FFA07A"
        ),
        FruitModel("Fig",
            "https://upload.wikimedia.org/wikipedia/commons/1/19/Figs_on_tree.jpg",
            "A small, sweet fruit with soft skin and many seeds.",
            "#A52A2A"
        ),
        FruitModel("Gooseberry",
            "https://upload.wikimedia.org/wikipedia/commons/c/c1/Gooseberries.jpg",
            "A small, tart berry that can be green, red, or purple.",
            "#7FFF00"
        ),
        FruitModel("Jackfruit",
            "https://upload.wikimedia.org/wikipedia/commons/f/f2/Jackfruit_hanging.JPG",
            "A massive tropical fruit with sweet, fibrous yellow pods.",
            "#FFD700"
        ),
        FruitModel("Lemon",
            "https://upload.wikimedia.org/wikipedia/commons/c/c5/Lemon.jpg",
            "A bright yellow citrus fruit known for its sour flavor.",
            "#FFF44F"
        ),
        FruitModel("Lime",
            "https://upload.wikimedia.org/wikipedia/commons/c/c4/Limes.jpg",
            "A small green citrus fruit with tart juice.",
            "#32CD32"
        ),
        FruitModel("Passion Fruit",
            "https://upload.wikimedia.org/wikipedia/commons/b/b8/Passion_fruit_and_cross_section.jpg",
            "A tropical fruit with a wrinkly purple skin and tangy pulp.",
            "#800080"
        ),
        FruitModel("Persimmon",
            "https://upload.wikimedia.org/wikipedia/commons/c/c8/Persimmon.jpg",
            "A sweet, orange fruit with a smooth texture when ripe.",
            "#FF7518"
        )
    )
}


