package com.example.navigationfragment.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragment.R
import com.example.navigationfragment.album.AlbumAdapter
import com.example.navigationfragment.album.AlbumDetailActivity
import com.example.navigationfragment.model.Album

class ListAlbumFragment : Fragment(), View.OnClickListener  {

    lateinit var albums: MutableList<Album>
    lateinit var adapter: AlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albums = mutableListOf<Album>()
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("OffSpring", "Nouveau album du groupe mythique"))
        albums.add(
            Album("Metallica", "L'album Metallica sort en 1991. Avec sa pochette presque entièrement noire, il est rapidement surnommé le Black Album tant par les fans que les membres du groupe. Cet album est à l'heure actuelle le plus grand succès commercial du groupe, avec plus de 30 millions d'exemplaires vendus à travers le monde3.\n" +
                                "\n" +
                                "L'album marque une évolution importante dans le style du groupe. Les tempos sont plus lents, les morceaux sont plus courts et leurs structures beaucoup plus simples, aspirant ainsi à du simple rock. C'est principalement un album de heavy metal, et il n'y a plus beaucoup de traces de thrash metal. Par son côté plus « commercial » que les précédents albums du groupe, qui a déplu à un certain nombre de fans de la première heure, il lui a permis d'atteindre un plus large public. C'est aussi le premier album du groupe produit par Bob Rock qui restera leur producteur jusqu'à St. Anger. Comme dans ...And Justice for All, Jason Newsted ne collabore qu'à un seul titre dans l'écriture des chansons. ")
        )
        albums.add(Album("NTM", "Nouveau album du groupe mythique"))
        albums.add(Album("Dido", "Nouveau album du groupe mythique"))
        albums.add(Album("Booba", "Nouveau album du groupe mythique"))
        albums.add(
            Album("The Rolling Stone", "Il est formé en 1962 par le guitariste et leader original Brian Jones, le pianiste Ian Stewart, le chanteur Mick Jagger, le guitariste Keith Richards, le bassiste Dick Taylor et le batteur Mick Avory. Le bassiste Bill Wyman et le batteur Charlie Watts les rejoignent ensuite après les départs de Dick Taylor et Mick Avory. Ian Stewart est écarté de la formation officielle par le manager du groupe Andrew Loog Oldham dès mai 1963, mais continue à travailler (comme road manager et comme pianiste) avec le groupe jusqu'à sa mort en 1985. Jagger et Richards constituent rapidement un duo d'auteurs-compositeurs et prennent peu à peu la direction du groupe, écartant progressivement un Brian Jones de plus en plus erratique.\n" +
                            "\n" +
                            "Le nom du groupe vient d'une chanson de Muddy Waters, Rollin' Stone, choisie par Brian Jones. Le blues a toujours été la source d'inspiration principale des Stones, qui sont l'un des principaux acteurs du retour de cette musique sur le devant de la scène, à travers le « British blues boom ». Les premiers enregistrements des Rolling Stones sont des reprises de blues et de rhythm and blues américains. Après avoir rencontré le succès au Royaume-Uni, ils deviennent populaires aux États-Unis, durant la « British Invasion » (initiée par les Beatles) du milieu des années 1960. Leur single de 1965 (I Can't Get No) Satisfaction les fait connaître dans le monde entier. ")
        )
        albums.add(Album("Pink Floyd", "Impossible de rester les bras ballants à l’horizon des cinquante ans du 8e album du groupe de rock britannique Pink Floyd, leur chef d’œuvre psychédélique. Considéré comme l’un des albums les plus influents du rock, The Dark Side of The Moon est aussi l’un des disques les plus vendus de tous les temps – plus de 45 millions d’exemplaires dans le monde. Cet album, le groupe l'avait testé, peaufiné et étrenné sur la route durant plus d'un an avant sa sortie en mars 1973, et 18 albums live issus de ces concerts sont sortis discrètement en décembre sur les plateformes de streaming, une façon pour Pink Floyd d'en conserver les copyright. Mais pour fêter dignement les 50 ans, le groupe et sa maison de disques Warner Music ont mis les petits plats dans les grands et le font savoir. "))
        albums.add(
            Album("Wu-Tang Clan", "Un disque enregistré pendant six ans, produit en un seul exemplaire, scellé dans une boîte ouvragée et interdit d’accès au commun des mortels (sauf celui qui acceptera d’y mettre le prix) : c’est le concept, aussi artistique que marketing et financier, de Once Upon A Time In Shaolin, un double-album du Wu-Tang Clan composé de 31 titres. Son existence avait été révélée en mars 2014, occultant l’effet d’annonce d’un autre album, A Better Tomorrow, qui fêtait les 20 ans du groupe.\n" +
                            "\n" +
                            "On apprend, ce mercredi 25 novembre, que Once Upon A Time In Shaolin a été vendu. Il a séduit, rapporte Forbes, un « collectionneur américain » anonyme. Si le montant exact de la transaction n’a pas été révélé, le magazine économique américain assure qu’il représente plusieurs millions de dollars. Un mois seulement après l’annonce de l’album, le rappeur RZA annonçait que l’offre la plus conséquente s’élevait à 5 millions de dollars.\n" +
                            "\n" +
                            "Ce montant fait de Once Upon A Time In Shaolin le disque le plus cher de l’histoire. Il détrône un vinyle original d’Elvis Presley, acheté en mars dernier par Jack White lors d’une vente aux enchères pour la somme de 300 000 dollars (soit environ 280 000 euros).")
        )
        albums.add(
            Album("Dire Strait", "Mark Knopfler est un journaliste âgé de 27 ans quand son frère David lui présente le bassiste John Illsley. Tous deux décident alors de s'installer dans un studio et de tenter de vivre de leur musique. Les débuts sont difficiles et le groupe vit avec des moyens très limités.\n" +
                                "\n" +
                                "C'est cette situation qui influence le groupe, initialement appelé The Cafe Racers4, pour le choix de son nom : to be in dire straits peut en effet se traduire par \"être dans la dèche\", \"avoir du mal à joindre les deux bouts\" ou \"être dans une situation désespérée (financièrement)\".\n" +
                                "\n" +
                                "Dans leur petit studio, Mark Knopfler compose en 1977 le titre qui reste comme l'hymne du groupe : Sultans of Swing, un hommage à tous les musiciens de bar et cabaret. Charlie Gillett diffuse alors la bande sans prévenir les membres du groupe lors de son émission Honky Tonk. Plusieurs producteurs le contactent dans les instants qui suivent. C'est finalement Phonogram qui les engage pour cinq albums. ")
        )
        albums.add(Album("Nas", "Nouveau album du groupe mythique"))

        adapter = AlbumAdapter(albums, this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.list_album_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter


    }

    override fun onClick(view: View) {
        if (view.tag != null) {
            Log.i("AlbumDetailActivity", "Click sur une album de la liste !")
            showAlbumDetail(view.tag as Int)
        }
    }

    fun showAlbumDetail(albumIndex: Int) {
        val album = albums[albumIndex]

        val intent = Intent(requireActivity(), AlbumDetailActivity::class.java)
        intent.putExtra(AlbumDetailActivity.EXTRA_ALBUM, album)
        intent.putExtra(AlbumDetailActivity.EXTRA_ALBUM_INDEX, -1)
        startActivity(intent)

    }

}