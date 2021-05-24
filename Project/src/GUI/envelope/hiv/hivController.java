package GUI.envelope.hiv;


import GUI.GeneralVirusController;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class hivController extends GeneralVirusController implements Initializable {
    private MediaPlayer mediaPlayer;
    private String path = "src/GUI/envelope/hiv/media/animation.mp4";
    @FXML
    private ImageView image;
    @FXML
    private Slider volumnBar;
    @FXML
    private Slider progress;
    @FXML
    private TextArea textExplain;



    @Override
    public void initialize(URL agr0, ResourceBundle agr1) {
    }

    @Override
    public void video(ActionEvent e) {
        super.video(e);
        File file = new File(this.path);
        Media m = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(m);
        media.setMediaPlayer(mediaPlayer);

        volumnBar.setValue(mediaPlayer.getVolume() * 100);
        volumnBar.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(volumnBar.getValue() / 100);
                if (volumnBar.getValue() == 0){
                    muted.setVisible(true);
                    volumn.setVisible(false);
                }else{volumn.setVisible(true);muted.setVisible(false);}
            }
        });

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                                                          @Override
                                                          public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                                                              progress.setValue(newValue.toSeconds());
                                                              moment.setText(""+ String.format("%02d", (int) newValue.toSeconds()/60) +":" + String.format("%02d",(int)newValue.toSeconds()%60));
                                                          }
                                                      }
        );

        progress.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.seek(Duration.seconds(progress.getValue()));
            }
        });

        progress.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.seek(Duration.seconds(progress.getValue()));
            }
        });

        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
                double total = mediaPlayer.getStopTime().toSeconds();
                progress.setMax(total);
            }
        });

        mediaPlayer.play();
    }

    @Override
    public void virusStructure(ActionEvent e) {
        super.virusStructure(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }

    @Override
    public void home(ActionEvent e) throws IOException {
        super.home(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }
    @Override
    public void animation(ActionEvent e){
        super.animation(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }

    }

    @FXML
    public void play(ActionEvent e) {
        mediaPlayer.play();
        mediaPlayer.setRate(1);

    }

    @FXML
    public void pause(ActionEvent e) {
        mediaPlayer.pause();

    }

    @FXML
    public void skipUp(ActionEvent e) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(5)));

    }

    @FXML
    public void skipDown(ActionEvent e) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-5)));
    }

    @FXML
    public void slow(ActionEvent e) {
        mediaPlayer.setRate(2);

    }

    @FXML
    public void fast(ActionEvent e) {
        mediaPlayer.setRate(2);

    }

    @FXML
    public void mute() {
        if (volumnBar.getValue() > 0) {
            volumnBar.setValue(0);
            muted.setVisible(true);
            volumn.setVisible(false);
        } else {
            volumnBar.setValue(10);
            muted.setVisible(false);
            volumn.setVisible(true);
        }

    }
    @FXML
    void showGp120(ActionEvent event) {
        textExplain.setText("Glycoprotein GP120:\n" +
                "Gp120 is coded by the HIV env gene, which is around 2.5 kb long and codes for around 850 amino acids." +
                " The primary env product is the protein gp160, which gets cleaved to gp120 (~480 amino acids) and gp41 (~345 amino acids)" +
                " in the endoplasmatic reticulum by the cellular protease furin. The crystal structure of core gp120 shows an organization" +
                " with an outer domain, an inner domain with respect to its termini and a bridging sheet. Gp120 is anchored to the viral membrane," +
                " or envelope, via non-covalent bonds with the transmembrane glycoprotein, gp41. Three gp120s and gp41s combine in a trimer of" +
                " heterodimers to form the envelope spike,[8] which mediates attachment to and entry into the host cell.\n");

    }

    @FXML
    void showGp41(ActionEvent event) {
        textExplain.setText("Glycoprotein GP41:\n" +
                "Gp41 also known as glycoprotein 41 is a subunit of the envelope protein complex of retroviruses, including human immunodeficiency virus (HIV)." +
                " Gp41 is a transmembrane protein that contains several sites within its ectodomain that are required for infection of host cells." +
                " As a result of its importance in host cell infection," +
                " it has also received much attention as a potential target" +
                " for HIV vaccines. Gp41 has three prominent regions within " +
                "the sequence: the ectodomain, the transmembrane domain, and the " +
                "cytoplasmic domain. The ectodomain, which comprises residues 511-684," +
                " can be further broken down into the fusion peptide region " +
                "(residues 512-527), the helical N-terminal heptad repeat (NHR) and" +
                " C-terminal heptad repeat (CHR). In addition to these regions, there is also a loop region that contains" +
                " disulfide bonds that stabilize the hairpin structure (the folded conformation of gp41) and a region called the membrane proximal external region (MPER) which " +
                "contains kinks that are antigen target regions. ");

    }

    @FXML
    void showHumanClass1(ActionEvent event) {
        textExplain.setText("Human Leukoctye Antigen Class 1:\n" +
                "The rapid and extensive spread of the human immunodeficiency virus (HIV) epidemic provides a rare opportunity " +
                "to witness host-pathogen co-evolution involving humans. A focal point is the interaction between genes encoding human " +
                "leukocyte antigen (HLA) and those encoding HIV proteins. HLA molecules present fragments (epitopes) of HIV proteins on " +
                "the surface of infected cells to enable immune recognition and killing by CD8(+) T cells; particular HLA molecules," +
                " such as HLA-B*57, HLA-B*27 and HLA-B*51, are more likely to mediate successful control of HIV infection. " +
                "Mutation within these epitopes can allow viral escape from CD8(+) T-cell recognition. Here we analysed viral sequences" +
                " and HLA alleles from >2,800 subjects, drawn from 9 distinct study cohorts spanning 5 continents." +
                " Initial analysis of the HLA-B*51-restricted epitope, TAFTIPSI (reverse transcriptase residues 128-135), " +
                "showed a strong correlation between the frequency of the escape mutation I135X and HLA-B*51 prevalence in the 9 study cohorts (P = 0.0001\n");

    }

    @FXML
    void showHumanClass2(ActionEvent event) {
        textExplain.setText("Human Leukoctye Antigen Class 2: \n" +
                "Human leukocyte antigen (HLA) class II molecules are essential in antigen presentation to CD4 T cells for activation of B cells to produce antibodies." +
                " We genotyped the classical HLA-DRB1, DQB1, and DPB1 genes in 450 individuals from the placebo arm of the RV144 study to determine the background allele " +
                "and haplotype frequencies of these genes in this cohort. High-resolution 4 and 6-digit class II HLA typing data was generated using sequencing-based methods. " +
                "The observed diversity for the HLA loci was 33 HLA-DRB1, 15 HLA-DQB1, and 26 HLA-DPB1 alleles. Common alleles with frequencies greater than 10% ");

    }

    @FXML
    void showIntegrase(ActionEvent event) {
        textExplain.setText("Integrase:\n" +
                "Retroviral integrase (IN) is an enzyme produced by a retrovirus (such as HIV) that integrates—forms covalent" +
                " links between—its genetic information into that of the host cell it infects.[1] Retroviral INs are not to be " +
                "confused with phage integrases (recombinases), such as λ phage integrase, as discussed in site-specific " +
                "recombination.HIV integrase is a 32 kDa protein produced from the C-terminal portion of the Pol gene product, " +
                "and is an attractive target for new anti-HIV drugs.\n");

    }

    @FXML
    void showLipidBilayer(ActionEvent event) {
        textExplain.setText("Lipid bilayer:\n" +
                "The envelope glycoproteins (Envs) of HIV-1 are embedded in the cholesterol-rich lipid membrane of the" +
                " virus. Chemical depletion of cholesterol from HIV-1 particles inactivates their infectivity." +
                " We observed that diverse HIV-1 strains exhibit a range of sensitivities to such treatment." +
                " Differences in sensitivity to cholesterol depletion could not be explained by variation in" +
                " Env components known to interact with cholesterol, including the cholesterol-recognition " +
                "motif and cytoplasmic tail of gp41. Using antibody-binding assays, measurements of virus infectivity," +
                " and analyses of lipid membrane order, we found that depletion of cholesterol from HIV-1 particles" +
                " decreases the conformational stability of Env. It enhances exposure of partially cryptic epitopes " +
                "on the trimer and increases sensitivity to structure-perturbing treatments such as antibodies and cold" +
                " denaturation. Substitutions in the cholesterol-interacting motif of gp41 induced similar effects as" +
                " depletion of cholesterol. Surface-acting agents, which are incorporated into the virus lipid membrane, " +
                "caused similar effects as disruption of the Env-cholesterol interaction.\n");

    }

    @FXML
    void showMatrixProtein(ActionEvent event) {
        textExplain.setText("Matrix protein p17:\n" +
                "The HIV-1 matrix protein p17 is a structural protein critically involved in most stages of the life " +
                "cycle of the retrovirus. It participates in the early stages of virus replication as well as in RNA" +
                " targeting to the plasma membrane, incorporation of the envelope into virions and particle assembly." +
                " Besides its well established functions, p17 acts as a viral cytokine that works on preactivated--but" +
                " not on resting--human T cells promoting proliferation, proinflammatory cytokines release and HIV-1 " +
                "replication after binding to a cellular receptor (p17R). Thus, p17 might play a key role in the complex " +
                "network of host- and virus-derived stimulatory factors contributing to create a favourable environment" +
                " for HIV-1 infection and replication. Here, we present a brief overview of the functions played by" +
                " the matrix protein p17 in the HIV-1 life cycle and summarize the current understanding of how p17" +
                " could contribute to the pathogenesis of HIV-1 disease.\n");


    }

    @FXML
    void showNucleocapsid(ActionEvent event) {
        textExplain.setText("Nucleocapsid p24:\n" +
                "One distinctive HIV antigen is a viral protein called p24, a structural protein that makes up most of " +
                "the HIV viral core, or 'capsid'. High levels of p24 are present in the blood serum of newly infected " +
                "individuals during the short period between infection and seroconversion, making p24 antigen assays" +
                " useful in diagnosing primary HIV infection. Antibodies to p24 are produced during seroconversion, " +
                "rendering p24 antigen undetectable after seroconversion in most cases. Therefore, p24 antigen assays" +
                " are not reliable for diagnosing HIV infection after its very earliest stages\n");

    }


    @FXML
    void showProtease(ActionEvent event) {
        textExplain.setText("Protease:\n" +
                "HIV-1 protease (PR) is a retroviral aspartyl protease (retropepsin), an enzyme involved with peptide" +
                " bond hydrolysis in retroviruses, that is essential for the life-cycle of HIV, the retrovirus that " +
                "causes AIDS.Mature HIV protease exists as a 22 kDa homodimer, with each subunit made up of 99 amino" +
                " acids. A single active site lies between the identical subunits and has the characteristic Asp-Thr-Gly" +
                " (Asp25, Thr26 and Gly27) catalytic triad sequence common to aspartic proteases. As HIV-1 PR can only" +
                " function as a dimer, the mature protease contains two Asp25 amino acids, one from each monomer, that " +
                "act in conjunction with each other as the catalytic residues. Additionally, HIV protease has two " +
                "molecular \"flaps\" which move a distance of up to 7 Å when the enzyme becomes associated with" +
                " a substrate. This can be visualized with animations of the flaps opening and closing.\n");

    }

    @FXML
    void showProteinP79(ActionEvent event) {
        textExplain.setText("Protein p7,p9:\n" +
                "Gag protein, p7 or p9, is termed the nucleocapsid protein, and is tightly associated with the RNA " +
                "genome: it has been found to promote both RNA dimerization and encapsidation. The most C-terminal" +
                " of the Gag proteins is p6; although its function is not known, mutants lacking this protein exhibit" +
                " a defect in particle budding.\n");

    }

    @FXML
    void showRNA(ActionEvent event) {
        textExplain.setText("RNA:\n" +
                "Upon entry into the target cell, the viral RNA genome is converted (reversed) to double-stranded DNA " +
                "by the reverse transcriptase enzyme that has been transported with the viral genome in viral particles." +
                " The generated viral DNA is then inserted into the cell nucleus and integrated into the cell's DNA by" +
                " the viral integrase enzyme and host cell cofactors. Once integrated, the virus becomes latent, " +
                "allowing the virus and its host cells to avoid detection by the immune system. Alternatively, the " +
                "virus can be replicated, producing viral RNA and protein genomes, and then packaged and released from" +
                " the cell as new viral particles and initiate a continuing cycle of replication.\n");


    }

    @FXML
    void showReverse(ActionEvent event) {
        textExplain.setText("Reverse Transccriptase:\n" +
                "A reverse transcriptase (RT) is an enzyme used to generate complementary DNA (cDNA) from an RNA" +
                " template, a process termed reverse transcription. Reverse transcriptases are used by certain" +
                " viruses such as HIV and hepatitis B to replicate their genomes, by retrotransposon mobile genetic " +
                "elements to proliferate within the host genome, and by eukaryotic cells to extend the telomeres at " +
                "the ends of their linear chromosomes. Contrary to a widely held belief, the process does not violate t" +
                "he flows of genetic information as described by the classical central dogma, as transfers of " +
                "information from RNA to DNA are explicitly held possible. Reverse-transcribing DNA viruses, " +
                "such as the hepadnaviruses, can allow RNA to serve as a template in assembling and making DNA strands." +
                " HIV infects humans with the use of this enzyme. Without reverse transcriptase, the viral genome would " +
                "not be able to incorporate into the host cell, resulting in failure to replicate.\n");


    }

}
