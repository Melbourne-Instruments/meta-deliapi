SUMMARY = "System files and startup scripts for the ElkPi board"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "\
    file://run_delia_ui \
    file://run_delia_gui \
    file://run_sushi \
    file://fw_env.config \
    file://make_rw \
    file://make_ro \
    file://kill_sushi \
"

do_install_append() {
    rm -f ${D}${bindir}/connect-midi-apps
    install -m 0755 ${WORKDIR}/run_delia_ui ${D}${bindir}
    install -m 0755 ${WORKDIR}/run_delia_gui ${D}${bindir}
    install -m 0755 ${WORKDIR}/run_sushi ${D}${bindir}
    install -m 0755 ${WORKDIR}/make_rw ${D}${bindir}
    install -m 0755 ${WORKDIR}/make_ro ${D}${bindir}
    install -m 0755 ${WORKDIR}/kill_sushi ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config    
}
